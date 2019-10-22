package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 02:55
 * @Description: 类加载器相关加载器类型
 */
public class ClassLoaderTest7 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        Class<?> c = Class.forName("com.sen.jvm.lecture.classloader.C");
        System.out.println(c.getClassLoader());
    }
}

class C{

}