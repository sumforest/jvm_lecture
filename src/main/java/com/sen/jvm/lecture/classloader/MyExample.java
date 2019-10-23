package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 21:58
 * @Description:
 */
public class MyExample {

    public MyExample() {
        System.out.println("MyExample is loading by:" + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("form MyExample:" + MyCat.class);
    }
}
