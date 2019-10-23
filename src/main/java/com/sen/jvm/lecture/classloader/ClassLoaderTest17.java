package com.sen.jvm.lecture.classloader;

import java.lang.reflect.Method;

/**
 * @Auther: Sen
 * @Date: 2019/10/24 01:20
 * @Description:
 */
public class ClassLoaderTest17 {

    public static void main(String[] args) throws Exception {
        ClassLoaderTest13 loader1 = new ClassLoaderTest13("loader1");
        ClassLoaderTest13 loader2 = new ClassLoaderTest13("loader2");
        loader1.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");
        loader2.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");

        Class<?> clazz1 = loader1.loadClass("com.sen.jvm.lecture.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.sen.jvm.lecture.classloader.MyPerson");

        /*
            输出结果为false
            因为已经把MyPerson.class文件上删除，所以应用类加载器不能加载该类而由自定义的
            类加载器加载。自定义加载器loader1和loader2没有任何直接或者间接的父子关系所以它们的命名空间是
            不同的，所以clazz1和clazz2是一个不同的对象
         */
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        /*
            抛类转换异常
            java.lang.ClassCastException: com.sen.jvm.lecture.classloader.MyPerson
            cannot be cast to com.sen.jvm.lecture.classloader.MyPerson
            因为clazz1和clazz2分别是连个不同的命名空间所以object2对object1不可见
         */
        method.invoke(object1, object2);
    }
}
