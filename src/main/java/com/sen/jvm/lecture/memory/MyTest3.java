package com.sen.jvm.lecture.memory;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Sen
 * @Date: 2020/1/8 00:19
 * @Description: 利用jconsole和jvisualvm检测死锁
 */
public class MyTest3 {

    public static void main(String[] args) {
        new Thread(A::methodA,"Thread-A").start();
        new Thread(B::methodB,"Thread-B").start();
    }

    private static class A{
        public synchronized static void methodA() {
            System.out.println("method A");
            try {
                TimeUnit.SECONDS.sleep(2);
                B.methodB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class B{
        public synchronized static void methodB(){
            System.out.println("method B");
            try {
                TimeUnit.SECONDS.sleep(3);
                A.methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
