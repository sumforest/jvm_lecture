package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/24 17:25
 * @Description:
 */
public class ClassLoaderTest19 implements Runnable {

    private Thread thread;

    public ClassLoaderTest19() {
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("classLoader:" + classLoader.getClass());
        System.out.println("parent:"+classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new ClassLoaderTest19();
    }
}
