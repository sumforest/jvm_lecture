package com.sen.jvm.lecture.gc;

/**
 * @Auther: Sen
 * @Date: 2020/1/9 19:10
 * @Description: CMS垃圾收集器日志分析
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10m
 * -XX:SurvivorRatio=8
 * -XX:+PrintGCDetails
 * -XX:+UseConcMarkSweepGC
 */
public class MyTest5 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes1 = new byte[4 * size];
        System.out.println("-------------1-------------");
        byte[] bytes2 = new byte[4 * size];
        System.out.println("-------------2-------------");
        byte[] bytes3 = new byte[4 * size];
        System.out.println("-------------3-------------");
        byte[] bytes4 = new byte[2 * size];
        System.out.println("-------------4-------------");

    }
}
