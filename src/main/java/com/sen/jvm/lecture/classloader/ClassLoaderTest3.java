package com.sen.jvm.lecture.classloader;

import java.util.UUID;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 23:07
 * @Description: 当定义的常量在编译期无法确定时，该常量就不能被存入调用该常量的方法所在的常量池中，导致定义
 * 该常量的类在该常量被调用时初始化。
 */
public class ClassLoaderTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.STRING);
    }
}
class MyParent3{
    public static final String STRING = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent2 inits");
    }
}