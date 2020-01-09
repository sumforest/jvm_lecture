package com.sen.jvm.lecture.gc;

/**
 * @Auther: Sen
 * @Date: 2020/1/9 16:11
 * @Description: MaxTenuringThreshold参数设置与动态调整
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:+PrintCommandLineFlags 打印JVM启动参数
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=5 新生代晋升老年代的年龄阈值
 * -XX:+PrintTenuringDistribution TenuringThreshold信息
 */
public class MyTest3 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];
        byte[] bytes3 = new byte[2 * size];
        byte[] bytes4 = new byte[2 * size];
        System.out.println("Hello GC Log !");
    }
}
