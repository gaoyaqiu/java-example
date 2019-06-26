package com.gyq.base.io;

import java.io.File;
import java.io.IOException;

/**
 * Java io File类 学习笔记.
 *
 * @author gaoyaqiu
 */
public class FileDemo {

    public static void main(String[] args) throws Exception {

        constructFile();
        System.out.println("=========================================");

//        createFile();
//        System.out.println("=========================================");
//
//        File file = new File("/Users/gaoyaqiu/Downloads/bak/io");
//        getFileList(file);
    }

    /**
     * 构造 File 对象.
     */
    public static void constructFile() throws IOException {
        // 不使用 Java 提供的分隔符，这种写法只在 Windows 平台有效
        File file1 = new File("D:\\io\\test.txt");
        System.out.println("file1 : " + file1);
        line();

        // 使用 Java 提供的分隔符
        File file2 = new File("D:" + File.separator + "io" + File.separator + "test.txt");
        System.out.println("file2: " + file2);
        line();

        File file3 = new File("/Users/gaoyaqiu/Downloads/bak/io");
        // 从父抽象路径名和子路径名字符串创建新的 File 实例.
        File file4 = new File(file3, "child");
        System.out.println("file4: " + file4);
        line();

        // 通过将给定的路径名字符串转换为抽象路径名来创建新的 File 实例.
        File file5 = new File("/Users/gaoyaqiu/Downloads/bak/io/test.txt");
        System.out.println("file5: " + file5);
        line();

        // 从父路径名字符串和子路径名字符串创建新的 File实例.
        File file6 = new File("/Users/gaoyaqiu/Downloads/bak", "io/test2.txt");
        System.out.println("file6: " + file6);
        System.out.println(file6.getAbsolutePath());
        System.out.println(file6.getCanonicalFile());
        System.out.println(file6.getPath());
    }

    /**
     * 创建文件.
     *
     * @throws IOException
     */
    public static void createFile() throws IOException {
        File file = new File("/Users/gaoyaqiu/Downloads/bak", "io/file.txt");
        System.out.println("file: " + file);

        boolean result = createMissingParentDirectories(file);
        if (!result) {
            System.out.println("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            return;
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        // 返回由此抽象路径名表示的文件或目录的名称
        System.out.println(file.getName());
        // 返回此抽象路径名的父路径名字符串，如果此路径名未命名为父目录，则返回null。
        System.out.println(file.getParent());
        // 将此抽象路径名转换为路径名字符串，结果字符串使用default name-separator character以名称顺序分隔名称。
        System.out.println(file.getPath());
    }

    /**
     * 获取目录下所有的文件.
     *
     * @param file
     */
    public static void getFileList(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println("file: " + f);
            if (f.isDirectory()) {
                getFileList(f);
            }
        }
    }

    private static boolean createMissingParentDirectories(File file) {
        File parent = file.getParentFile();
        if (parent == null) {
            return true;
        }

        // 父类不存在时，首先创建父目录，即使存在执行该方法也没有关系
        parent.mkdirs();
        return parent.exists();
    }

    private static void line() {
        System.out.println();
    }
}
