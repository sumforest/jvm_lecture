package com.sen.jvm.lecture.memory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Sen
 * @Date: 2020/1/7 23:26
 * @Description: 虚拟机栈溢出分析
 * JVM参数：
 * -Xss100k
 * 抛出Error:java.lang.StackOverflowError
 */
public class MyTest2 {

    private int length;

    public void test(){
        this.length++;
        try {
            TimeUnit.MILLISECONDS.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Throwable t) {
            t.printStackTrace();
        }finally {
            System.out.println(myTest2.length);
        }
    }
}
