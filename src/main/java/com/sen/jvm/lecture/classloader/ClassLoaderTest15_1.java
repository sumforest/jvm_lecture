package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 23:42
 * @Description: 根类加载器演示
 */
public class ClassLoaderTest15_1 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderTest13 loader1 = new ClassLoaderTest13("loader1");
        Class<?> clazz = loader1.loadClass("com.sen.jvm.lecture.classloader.ClassLoaderTest1");
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz);
    }
}
