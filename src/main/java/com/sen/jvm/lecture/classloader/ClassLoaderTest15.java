package com.sen.jvm.lecture.classloader;

import sun.misc.Launcher;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 23:34
 * @Description:
 */
public class ClassLoaderTest15 {

    public static void main(String[] args) {
        /*
        把根类加载器的路径修改为当前路径
        java -Dsun.boot.class.path=./ com.sen.jvm.lecture.classloader.ClassLoaderTest15
        会报错
        Error occurred during initialization of VM
        java/lang/NoClassDefFoundError: java/lang/Object
        原因:根类加载器是加载其他类加载器的和java平台类的的基础，其存是存在与jvm的机器码
         */
        //根类加载器的加载位置
        System.out.println(System.getProperty("sun.boot.class.path"));
        //扩展类加载器加载位置
        System.out.println(System.getProperty("java.ext.dirs"));
        //应用类加载器加载位置
        System.out.println(System.getProperty("java.class.path"));

        //验证其他类加载器都是由根类加载器加载
        System.out.println(ClassLoader.class.getClassLoader());

        //系统类加载器和扩展类加载器都位于Launcher类中，加载Launcher类的加载器会加载其内部类
        System.out.println(Launcher.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println("------------------------------");
        /*
        自定义系统类加载器
        1.在自定义加载器中提供一个ClassLoader参数的构造方法给父类ClassLoader调用
        2.java -Djava.system.class.loader=com.sen.jvm.lecture.classloader.ClassLoaderTest13
        com.sen.jvm.lecture.classloader.ClassLoaderTest15
        命令运行
        3.系统定义的系统类加载器作为自定义系统类加载器的父类
         */
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoaderTest13.class.getClassLoader());
    }
}
