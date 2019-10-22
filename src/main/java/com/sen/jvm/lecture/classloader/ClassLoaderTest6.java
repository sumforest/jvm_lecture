package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 01:00
 * @Description: 深入理解类加载器的初始化阶段和连接时的准备阶段的执行流程
 */
public class ClassLoaderTest6 {

    public static void main(String[] args) {
        Singleton1.getInstance();
        System.out.println("num1:" + Singleton1.num1);
        System.out.println("num2:" + Singleton1.num2);

        Singleton2.getInstance();
        System.out.println("num3:" + Singleton2.num3);
        System.out.println("num4:" + Singleton2.num4);
    }

}

class Singleton1 {

    public static int num1;

    public static int num2 = 0;

    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
        num1++;
        num2++;
    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}
class Singleton2 {

    public static int num3;

    private static Singleton2 singleton = new Singleton2();

    private Singleton2() {
        num3++;
        num4++;
    }

    public static int num4 = 0;

    public static Singleton2 getInstance() {
        return singleton;
    }
}