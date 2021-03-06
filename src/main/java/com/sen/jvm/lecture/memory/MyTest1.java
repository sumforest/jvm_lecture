package com.sen.jvm.lecture.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Sen
 * @Date: 2019/10/27 01:25
 * @Description:
 *  虚拟机栈：Stack Frame 栈帧
 * 	程序计数器：（Program Counter）
 * 	本地方法栈：主要用于处理本地方法
 * 	堆（Heap）：JVM管理的最大一块内存空间
 * 	方法区（Method Area）：存储元信息。永久代（Permanent Generation），从JDK 1.8开始，已经废弃了永久代，使用元
 * 	空间（meta space）
 * 	运行时常量池：方法区的一部分内容。
 * 	直接内存：Direct Memory
 *
 * 	测试堆内存溢出
 */
public class MyTest1 {

    /**
     * java.lang.OutOfMemoryError
     * 配置虚拟机参数：
     * -Xms5m
     * -Xmx5m
     * -XX:+HeapDumpOnOutOfMemoryError
     *
     * @param args
     */
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();
        for(;;){
            //强引用，避免被GC回收
            list.add(new MyTest1());
            //通知垃圾收集器进行GC

            /*
            参数
            -Xms5m
            -Xmx5m
            -XX:+HeapDumpOnOutOfMemoryError
            系统正常
            高频GC

            参数
            -Xms1m
            -Xmx1m
            -XX:+HeapDumpOnOutOfMemoryError
            java.lang.OutOfMemoryError: Java heap space

             参数
            -Xms2m
            -Xmx2m
            -XX:+HeapDumpOnOutOfMemoryError
            java.lang.OutOfMemoryError: Java heap space

            参数
            -Xms3m
            -Xmx3m
            -XX:+HeapDumpOnOutOfMemoryError
            java.lang.OutOfMemoryError: Java heap space
            频繁GC
            */
            //进行full gc不会导致java.lang.OutOfMemoryError: Java heap space
            System.gc();
        }
    }
}
