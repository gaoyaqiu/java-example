package com.gyq.pattern.proxy.customdynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class MyProxy {

    private static final String LN = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler invocationHandler)  {

        // 1. 编写源代码
        String proxySrc = generateSrc(interfaces);
        // 2. 生成java文件
        String srcPath = MyProxy.class.getResource("").getPath();
        File src = new File(srcPath + "$Proxy4.java");
        FileWriter fw = null;
        try {
            fw = new FileWriter(src);
            fw.write(proxySrc);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 编译源代码，生成class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = manager.getJavaFileObjects(src);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        try {
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4. 通过类加载器，将生成的class文件加载到jvm种运行
        Class proxyClass = null;
        try {
            proxyClass = classLoader.findClass("$Proxy4");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 5. 创建一个新的实例（已经不是原始的类名了）
        try {
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            return c.newInstance(invocationHandler);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            src.delete();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer src = new StringBuffer();

        src.append("package com.gyq.pattern.proxy.customdynamicproxy;" + LN);
        src.append("import java.lang.reflect.Method;" + LN);
        src.append("public class $Proxy4 implements " + interfaces[0].getName() + "{" + LN);

        src.append("MyInvocationHandler h;" + LN);

        // 生成构造方法
        src.append("public $Proxy4(MyInvocationHandler h) {" + LN);
        src.append("this.h = h;" + LN);
        src.append("}" + LN);

        // 生成方法
        for (Method m : interfaces[0].getMethods()) {
            src.append("public void " + m.getName() + "() {" + LN);

            src.append("try{" + LN);
            src.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{});" + LN);
            src.append("this.h.invoke(this, m, null);" + LN);

            src.append("}catch(Throwable throwable){}");
            src.append("}" + LN);
        }

        src.append("}" + LN);
        return src.toString();
    }
}
