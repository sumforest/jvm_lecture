package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 21:59
 * @Description: 关于命名空间的两个重要结论：
 * 1.子加载器所加载的类能够访问到父加载器所加载的类
 * 2.父加载器所加载到的类不能访问到子加载器所加载的类
 */
public class ClassLoaderTest14 {

    public static void main(String[] args) throws Exception {
        ClassLoaderTest13 loader1 = new ClassLoaderTest13("loader1");
        loader1.setPath("C:\\Users\\Sen\\OneDrive\\桌面\\");
        Class<?> clazz = loader1.loadClass("com.sen.jvm.lecture.classloader.MyExample");

        //如果注释改行，那么并不会实例化MyExample对象，不对调用该结构方法，
        //所以实例化MyCat对象，即没有对MyCat的主动使用，类加载器不会加载MyCat
        Object o = clazz.newInstance();

    }
}
