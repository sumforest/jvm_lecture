package com.sen.jvm.lecture.classloader;

import java.io.*;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 16:53
 * @Description: 自定义类加载器
 * 命名空间：每个类加载器都有其命名空间，命名空间指：加载器及其父类加载器所加载的类。
 * 相同命名空间类只会被加载一次，不同命名空间有肯能会被加载两次。
 */
public class ClassLoaderTest13 extends ClassLoader {

    private String classLoaderName;

    private final String FILE_EXTENSION = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public ClassLoaderTest13(String classLoaderName) {
        //不指定父加载器，默认的父加载器是系统类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public ClassLoaderTest13(ClassLoader parent, String classLoaderName) {
        //指定自定义类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /**
     * 用于自定义系统类加载器
     * @param parent 接收系统类加载器
     */
    public ClassLoaderTest13(ClassLoader parent){
        super(parent);
    }
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("MyClassLoader is Running");
        System.out.println("classLoaderName:" + classLoaderName);
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        byte[] data = null;
        InputStream in = null;
        ByteArrayOutputStream baos = null;

        try {
            className = className.replace(".", "\\");
            in = new FileInputStream(path + className + FILE_EXTENSION);
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = in.read()) != -1) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null && baos != null) {
                try {
                    in.close();
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        ClassLoaderTest13 loader1 = new ClassLoaderTest13("loader1");
        loader1.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");

        Class<?> clazz = loader1.loadClass("com.sen.jvm.lecture.classloader.ClassLoaderTest1");
        System.out.println("class:" + clazz.hashCode());
        Object o1 = clazz.newInstance();
        System.out.println(o1);

        //查看类的卸载
        loader1 = new ClassLoaderTest13("loader4");
        loader1.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");

        clazz = loader1.loadClass("com.sen.jvm.lecture.classloader.ClassLoaderTest1");
        System.out.println("class:" + clazz.hashCode());
        o1 = clazz.newInstance();
        //手动调用gc
        System.gc();
        Thread.sleep(100000);
        System.out.println(o1);

        // System.out.println("-----------------");
        // ClassLoaderTest13 loader2 = new ClassLoaderTest13(loader1,"loader2");
        // loader2.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");
        //
        // Class<?> clazz2 = loader2.loadClass("com.sen.jvm.lecture.classloader.ClassLoaderTest1");
        // System.out.println("class:" + clazz2.hashCode());
        // Object o2 = clazz2.newInstance();
        // System.out.println(o2);
        //
        // System.out.println("===============");
        // ClassLoaderTest13 loader3 = new ClassLoaderTest13(loader2,"loader3");
        // loader3.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");
        //
        // Class<?> clazz3 = loader3.loadClass("com.sen.jvm.lecture.classloader.ClassLoaderTest1");
        // System.out.println("class:" + clazz3.hashCode());
        // Object o3 = clazz3.newInstance();
        // System.out.println(o3);
    }
}
