package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/11/14 19:39
 * @Description: 静态内部类的加载
 */
public class ClassLoaderTest22 {

    public static void main(String[] args) {
        Child22 child22 = new Child22();
    }
}

class Parent22{
    static {
        System.out.println("Parent22 被初始化");
        new Singleton();
    }
    public static class Singleton{
        static {
            System.out.println("静态内部类被初始化");
        }
    }
}

class Child22 extends Parent22 {
    static {
        System.out.println("Child22 被初始化");
    }
}
