package com.sen.jvm.lecture.bytecode;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 21:44
 * @Description:
 */
public class RealSubject implements Subject {
    @Override
    public void required() {
        System.out.println("Real Subject");
    }
}
