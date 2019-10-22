package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 18:25
 * @Description: 对于静态变量来说，在调用时只有定义该静态变量的类才会被初始化
 * 对于子类来说，在调用该类定义的静态变量时这个类就会被初始化，连着它的父类也被初始化以及父类的父类
 * -XX:+TraceClassLoading 用于追踪类的加载信息并打印出来
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild.str2);
    }
}

class MyParent {
    public static String str = "hello world";

    static{
        System.out.println("MyParent is loaded");
    }
}
class MyChild extends MyParent{
    public static String str2 = "Welcome";

    static {
        System.out.println("MyChild inits");
    }
}
