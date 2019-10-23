package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/24 02:12
 * @Description: 详解扩展类加载器
 */
public class ClassLoaderTest18 {
    static {
        System.out.println("ClassLoaderTest18 init");
    }

    public static void main(String[] args) {
        System.out.println(ClassLoaderTest18.class.getClassLoader());
        System.out.println(ClassLoaderTest1.class.getClassLoader());
    }
}
