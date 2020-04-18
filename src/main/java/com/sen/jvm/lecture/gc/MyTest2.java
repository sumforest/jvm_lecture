package com.sen.jvm.lecture.gc;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Sen
 * @Date: 2020/1/9 15:11
 * @Description: 对象的分配分析
 * JVM参数：
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold=4194304 需要搭配Serial GC使用才生效
 */
public class MyTest2 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        /*
        JVM参数：
        -verbose:gc
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:+PrintGCDetails
        -XX:PretenureSizeThreshold=4194304 需要搭配Serial GC使用才生效

         Heap
         def new generation   total 9216K, used 2015K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          eden space 8192K,  24% used [0x00000000fec00000, 0x00000000fedf7d00, 0x00000000ff400000)
          from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
          to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
         tenured generation   total 10240K, used 5120K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
           the space 10240K,  50% used [0x00000000ff600000, 0x00000000ffb00010, 0x00000000ffb00200, 0x0000000100000000)
         Metaspace       used 3211K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 348K, capacity 388K, committed 512K, reserved 1048576K
         */
        // byte[] allocate = new byte[5 * size];

        /*
        JVM参数：
        -verbose:gc
        -Xms20m
        -Xmx20m
        -Xmn10m
        -XX:+PrintGCDetails

        Heap
         PSYoungGen      total 9216K, used 2015K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 24% used [0x00000000ff600000,0x00000000ff7f7d00,0x00000000ffe00000)
          from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
          to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
         ParOldGen       total 10240K, used 7168K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 70% used [0x00000000fec00000,0x00000000ff300010,0x00000000ff600000)
         Metaspace       used 3205K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 346K, capacity 388K, committed 512K, reserved 1048576K

        当在新生代创建的对象超过一定的大小在没配置阈值的时候也会直接分配到老年代
         */
        // byte[] allocate = new byte[7 * size];

        byte[] allocate = new byte[5 * size];
        try {
            TimeUnit.SECONDS.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
