package com.sen.jvm.lecture.memory;

/**
 * @Auther: Sen
 * @Date: 2020/1/7 23:43
 * @Description: 死锁
 */
public class DeadLock {

    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        new Thread(DeadLock::lock1).start();

        new Thread(DeadLock::lock2).start();
    }

    private static void lock1(){
        while (true) {
            synchronized (LOCK1) {
                lock3();
                System.out.println("LOCK1");
            }
        }
    }

    private static void lock2(){
        while (true) {
            synchronized (LOCK2) {
                lock1();
                System.out.println("LOCK2");
            }
        }
    }

    private static void lock3(){
        while (true) {
            synchronized (LOCK2) {
                System.out.println("LOCK2");
            }
        }
    }
}
