package com.gyq.base.io;

import java.io.File;
import java.io.IOException;

/**
 * Java io File类学习笔记.
 * File 类的常用方法
 * <p>
 * 　　①、创建方法
 * <p>
 * 　　　　1.boolean createNewFile() 不存在返回true 存在返回false
 * 　　　　2.boolean mkdir() 创建目录，如果上一级目录不存在，则会创建失败
 * 　　　　3.boolean mkdirs() 创建多级目录，如果上一级目录不存在也会自动创建
 * <p>
 * <p>
 * <p>
 * 　　②、删除方法
 * <p>
 * 　　　　1.boolean delete() 删除文件或目录，如果表示目录，则目录下必须为空才能删除
 * 　　　　2.boolean deleteOnExit() 文件使用完成后删除
 * <p>
 * <p>
 * <p>
 * 　　③、判断方法
 * <p>
 * 　　　　1.boolean canExecute()判断文件是否可执行
 * 　　　　2.boolean canRead()判断文件是否可读
 * 　　　　3.boolean canWrite() 判断文件是否可写
 * 　　　　4.boolean exists() 判断文件或目录是否存在
 * 　　　　5.boolean isDirectory()  判断此路径是否为一个目录
 * 　　　　6.boolean isFile()　　判断是否为一个文件
 * 　　　　7.boolean isHidden()　　判断是否为隐藏文件
 * 　　　　8.boolean isAbsolute()判断是否是绝对路径 文件不存在也能判断
 * <p>
 * <p>
 * <p>
 * 　　④、获取方法
 * <p>
 * 　　　　1.String getName() 获取此路径表示的文件或目录名称
 * 　　　　2.String getPath() 将此路径名转换为路径名字符串
 * 　　　　3.String getAbsolutePath() 返回此抽象路径名的绝对形式
 * 　　　　4.String getParent()//如果没有父目录返回null
 * 　　　　5.long lastModified()//获取最后一次修改的时间
 * 　　　　6.long length() 返回由此抽象路径名表示的文件的长度。
 * 　　　　7.boolean renameTo(File f) 重命名由此抽象路径名表示的文件。
 * 　　　　8.File[] liseRoots()//获取机器盘符
 * 　　　　9.String[] list()  返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
 * 　　　　10.String[] list(FilenameFilter filter) 返回一个字符串数组，命名由此抽象路径名表示的目录中满足指定过滤器的文件和目录。
 *
 * @author gaoyaqiu
 */
public class FileDemo {

    public static void main(String[] args) throws Exception {

        constructFile();
        System.out.println("=========================================");
        createFile();
        System.out.println("=========================================");
        File file = new File("/Users/gaoyaqiu/Downloads/bak/io");
        getFileList(file);
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

        // File(File parent, String child) 从父抽象路径名和子路径名字符串创建新的 File 实例.
        File file3 = new File("/Users/gaoyaqiu/Downloads/bak/io");
        File file4 = new File(file3, "child");
        System.out.println("file4: " + file4);
        line();

        // File(String pathname) 通过将给定的路径名字符串转换为抽象路径名来创建新的 File 实例.
        File file5 = new File("/Users/gaoyaqiu/Downloads/bak/io/test.txt");
        System.out.println("file5: " + file5);
        line();

        // File(String parent, String child) 从父路径名字符串和子路径名字符串创建新的 File实例.
        File file6 = new File("/Users/gaoyaqiu/Downloads/bak", "io/test2.txt");
        System.out.println("file6: " + file6);
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

        // 返回由此抽象路径名表示的文件或目录的名称。 这只是路径名称序列中的最后一个名字。 如果路径名的名称序列为空，则返回空字符串。
        System.out.println(file.getName());
        // 返回此抽象路径名的父null的路径名字符串，如果此路径名未命名为父目录，则返回null。
        System.out.println(file.getParent());
        // 将此抽象路径名转换为路径名字符串。 结果字符串使用default name-separator character以名称顺序分隔名称。
        System.out.println(file.getPath());
    }

    /**
     * 获取目录下所有的文件.
     *
     * @param file
     */
    public static void getFileList(File file){
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println("f: " + f);
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

        // 父类不存在时，首先创建父目录，即时存在执行该方法也没有关系
        parent.mkdirs();
        return parent.exists();
    }

    private static void line() {
        System.out.println();
    }
}
