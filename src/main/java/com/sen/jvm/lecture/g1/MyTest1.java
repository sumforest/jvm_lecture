package com.sen.jvm.lecture.g1;

/**
 * @Author: Sen
 * @Date: 2020/1/10 22:57
 * @Description: G1垃圾收集器日志分析
 * G1收集器不需要显示指定新生代、老年代的大小，交由G1收集器自动分配以实现期待的停顿时间
 * -verbose:gc
 * -Xms10m
 * -Xmx10m
 * -XX:+UseG1GC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m
 */
public class MyTest1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes1 = new byte[size];
        System.out.println("--------------------------1--------------------------");

        byte[] bytes2 = new byte[size];
        System.out.println("--------------------------2--------------------------");

        byte[] bytes3 = new byte[size];
        System.out.println("--------------------------3--------------------------");

        byte[] bytes4 = new byte[size];
        System.out.println("--------------------------4--------------------------");
    }
}
