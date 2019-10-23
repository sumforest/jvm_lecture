package com.sen.jvm.lecture.classloader;

import java.lang.reflect.Method;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 23:53
 * @Description:
 */
public class ClassLoaderTest16 {

    public static void main(String[] args) throws Exception {
        ClassLoaderTest13 loader1 = new ClassLoaderTest13("loader1");
        ClassLoaderTest13 loader2 = new ClassLoaderTest13("loader2");

        Class<?> clazz1 = loader1.loadClass("com.sen.jvm.lecture.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.sen.jvm.lecture.classloader.MyPerson");
        //输出为true loader1 和 loader2 虽然是连个不同的类加载器，但他们的父加载器都是系统加载器
        //当loader1加载实际执行的是系统加载器，loader2加载时不在加载将clazz1直接给clazz2
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        //动态调用方法
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
