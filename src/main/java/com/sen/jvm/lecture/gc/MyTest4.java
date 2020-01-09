package com.sen.jvm.lecture.gc;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Sen
 * @Date: 2020/1/9 16:59
 * @Description: TenuringThreshold动态调整
 * -verbose:gc
 * -Xmx200m
 * -Xmn50m
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte[] bytes1 = new byte[512 * 1024];
        byte[] bytes2 = new byte[512 * 1024];

        /*2020-01-09T17:09:47.931+0800: [GC (Allocation Failure) 2020-01-09T17:09:47.948+0800: [ParNew
            Desired survivor size 3145728 bytes, new threshold 3 (max 3)
            - age   1:    1768584 bytes,    1768584 total
            : 40349K->1761K(46080K), 0.0009275 secs] 40349K->1761K(199680K), 0.0185708 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
            ------------1-------------
            2020-01-09T17:09:48.951+0800: [GC (Allocation Failure) 2020-01-09T17:09:48.951+0800: [ParNew
            Desired survivor size 3145728 bytes, new threshold 3 (max 3)
            - age   1:     345952 bytes,     345952 total
            - age   2:    1762184 bytes,    2108136 total
            : 41894K->2339K(46080K), 0.0008307 secs] 41894K->2339K(199680K), 0.0008609 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            ------------2-------------
            2020-01-09T17:09:49.955+0800: [GC (Allocation Failure) 2020-01-09T17:09:49.955+0800: [ParNew
            Desired survivor size 3145728 bytes, new threshold 3 (max 3)
            - age   1:         96 bytes,         96 total
            - age   2:     345400 bytes,     345496 total
            - age   3:    1703488 bytes,    2048984 total
            : 42853K->2344K(46080K), 0.0008298 secs] 42853K->2344K(199680K), 0.0008663 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            ------------3-------------
            2020-01-09T17:09:50.959+0800: [GC (Allocation Failure) 2020-01-09T17:09:50.959+0800: [ParNew
            Desired survivor size 3145728 bytes, new threshold 3 (max 3)
            - age   1:         96 bytes,         96 total
            - age   2:         96 bytes,        192 total
            - age   3:     345400 bytes,     345592 total
            : 43064K->1085K(46080K), 0.0031998 secs] 43064K->2765K(199680K), 0.0032332 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            ------------4-------------
            2020-01-09T17:09:51.965+0800: [GC (Allocation Failure) 2020-01-09T17:09:51.965+0800: [ParNew
            Desired survivor size 3145728 bytes, new threshold 1 (max 3)
            //Survivor使用的内存超过了Survivor的空间的60%开始重新计算TenTenuringThreshold的值
            - age   1:    3145952 bytes,    3145952 total
            - age   2:         96 bytes,    3146048 total
            - age   3:         96 bytes,    3146144 total
            : 41620K->3269K(46080K), 0.0011435 secs] 43300K->5287K(199680K), 0.0011707 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
            ------------5-------------
            2020-01-09T17:09:52.969+0800: [GC (Allocation Failure) 2020-01-09T17:09:52.969+0800: [ParNew
            Desired survivor size 3145728 bytes, new threshold 3 (max 3)
            - age   1:         96 bytes,         96 total
            : 43995K->24K(46080K), 0.0014466 secs] 46012K->5114K(199680K), 0.0014725 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            ------------6-------------
            --------Completed---------
            Heap
             par new generation   total 46080K, used 18637K [0x00000000f3800000, 0x00000000f6a00000, 0x00000000f6a00000)
              eden space 40960K,  45% used [0x00000000f3800000, 0x00000000f4a2d188, 0x00000000f6000000)
              from space 5120K,   0% used [0x00000000f6000000, 0x00000000f60062b0, 0x00000000f6500000)
              to   space 5120K,   0% used [0x00000000f6500000, 0x00000000f6500000, 0x00000000f6a00000)
             concurrent mark-sweep generation total 153600K, used 5090K [0x00000000f6a00000, 0x0000000100000000, 0x0000000100000000)
             Metaspace       used 3774K, capacity 4536K, committed 4864K, reserved 1056768K
              class space    used 416K, capacity 428K, committed 512K, reserved 1048576K

            Process finished with exit code 0
*/
        myGc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------1-------------");

        myGc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------2-------------");

        myGc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------3-------------");

        myGc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------4-------------");

        byte[] bytes3 = new byte[1024 * 1024];
        byte[] bytes4 = new byte[1024 * 1024];
        byte[] bytes5 = new byte[1024 * 1024];
        myGc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------5-------------");

        myGc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------6-------------");
        System.out.println("--------Completed---------");

    }

    private static void myGc() {
        for (int i = 0; i < 40; i++) {
            byte[] bytes = new byte[1024 * 1024];
        }
    }
}
