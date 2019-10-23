package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 21:57
 * @Description:
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loading by:" + this.getClass().getClassLoader());
        // System.out.println("from MyCat:" + MyExample.class);
    }
}
