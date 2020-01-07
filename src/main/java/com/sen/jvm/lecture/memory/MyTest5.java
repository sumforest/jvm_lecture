package com.sen.jvm.lecture.memory;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Sen
 * @Date: 2020/1/8 02:28
 * @Description: 使用jmap、jstat工具监控虚拟机状态
 */
public class MyTest5 {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("Hello World!");
        }
    }
}
