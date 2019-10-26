package com.sen.jvm.lecture.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Auther: Sen
 * @Date: 2019/10/24 17:31
 * @Description: 线程上下文类加载器的使用：（获取-修改-还原）
 */
public class ClassLoaderTest20 {

    public static void main(String[] args) {
        /*
            添加行代码后ServiceLoader.load()无法加载到MySQL的驱动
            原因：
            1.根据jdk的双亲委托类加载机制，加载ServiceLoader类的加载器是由系统类加载器尝试加载实际是
            启动类加载器，此时启动类加载器会加载ServiceLoader类下的相关的类。
            2.ServiceLoader类加载mysql的驱动是以调用线程上下文类加载器即系统类加载器加载的，打破了双亲委
            托机制。
            3.线程的上下文类加载器是在Launcher类中设置为系统类加载器。
         */
        // Thread.currentThread().setContextClassLoader(ClassLoaderTest20.class.getClassLoader().getParent());

        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + "loader:" + driver.getClass().getClassLoader());
        }

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ServiceLoader.class.getClassLoader());
    }
}
