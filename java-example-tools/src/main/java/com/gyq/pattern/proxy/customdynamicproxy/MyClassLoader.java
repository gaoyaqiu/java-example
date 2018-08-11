package com.gyq.pattern.proxy.customdynamicproxy;

import java.io.*;

/**
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class MyClassLoader extends ClassLoader {

    private File classPath;

    public MyClassLoader() {
        String basePath = MyClassLoader.class.getResource("").getPath();
        classPath = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // class全称就是 包名+类名
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (null == classPath) {
            return null;
        }

        File classFile = new File(classPath, name.replaceAll("\\.", "/") + ".class");
        if (!classFile.exists()) {
            return null;
        }

        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(classFile);
            out = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }

            return defineClass(className, out.toByteArray(), 0, out.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            boolean b = classFile.delete();
            System.out.println(b);
        }

        return super.findClass(name);
    }
}
