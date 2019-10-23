package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 16:08
 * @Description: 数组的Class对象不是由类加载器创建，而是由虚拟机在运行时动态创建。数组的类加载器和该数组的
 * 元素的类加载器一致，但是对于原生类型（int, char, etc）数组没有类加载器。
 */
public class ClassLoaderTest12 {

    public static void main(String[] args) {
        String[] strings = new String[1];
        System.out.println(strings.getClass().getClassLoader());

        ClassLoaderTest12[] classLoaderTest12s = new ClassLoaderTest12[1];
        System.out.println(classLoaderTest12s.getClass().getClassLoader());

        int[] ints = new int[1];
        //输出的null不是指根类加载器，是为空，没有加载器
        System.out.println(ints.getClass().getClassLoader());
    }
}
