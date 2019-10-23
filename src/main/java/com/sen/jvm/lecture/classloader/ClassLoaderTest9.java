package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 14:25
 * @Description: 调用类加载器加载一个类的时候并不是对这个类的主动使用，不会导致被加载的类初始化；反射
 * 表示对该类的主动使用，会导致该类首次使用而被初始化。
 */
public class ClassLoaderTest9 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.sen.jvm.lecture.classloader.B");
        System.out.println(clazz);
        System.out.println("----------");
        clazz = Class.forName("com.sen.jvm.lecture.classloader.B");
        System.out.println(clazz);
    }
}

class B{

    static {
        System.out.println("B static block");
    }
}