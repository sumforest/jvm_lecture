package com.sen.jvm.lecture.gc;

/**
 * @Author: Sen
 * @Date: 2020/1/9 01:14
 * @Description: 查看GC日志
 * JVM参数：
 * -verbose:gc              产生详细的GC信息
 * -Xms20m                  最小堆内存
 * -Xmx20m                  最大堆内存
 * -Xmn10m                  新生代大小
 * -XX:+PrintGCDetails      控制台打印详细的GC日志
 * -XX:SurvivorRatio=8      新生代中Eden：From Survivor: To Survivor = 8:1:1
 */
public class MyTest1 {

    public static void main(String[] args) {
        /*
        [GC (Allocation Failure) [PSYoungGen: 5947K->776K(9216K)] 5947K->4880K(19456K), 0.0021641 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        Hello GC Log !
        Heap
         PSYoungGen      total 9216K, used 4171K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 41% used [0x00000000ff600000,0x00000000ff950db0,0x00000000ffe00000)
          from space 1024K, 75% used [0x00000000ffe00000,0x00000000ffec2020,0x00000000fff00000)
          to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         Metaspace       used 3214K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 348K, capacity 388K, committed 512K, reserved 1048576K
          年轻代经历minorGC后的大小变化 = 被GC对象大小 + 晋升老年代的对象大小             老年代对象大小
          (PSYoungGen: 5947K->776K) - ( 5947K->4880K(19456K)) = ParOldGen       total 10240K
                                        minorGC后的堆大小变化-->被会收的对象总大小
        */

        int size = 1024 * 1024;

        /*
        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];
        byte[] bytes3 = new byte[3 * size];
        */

        /*
        出现Full GC 发生时机：老年代使用量触发GC阈值
        [GC (Allocation Failure) [PSYoungGen: 7994K->776K(9216K)] 7994K->6928K(19456K), 0.0026400 secs] [Times: user=0.06 sys=0.02, real=0.00 secs]
        [Full GC (Ergonomics) [PSYoungGen: 776K->0K(9216K)] [ParOldGen: 6152K->6762K(10240K)] 6928K->6762K(19456K), [Metaspace: 3174K->3174K(1056768K)], 0.0042036 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        Hello GC Log !
        Heap
         PSYoungGen      total 9216K, used 2372K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 28% used [0x00000000ff600000,0x00000000ff8512c8,0x00000000ffe00000)
          from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
          to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         ParOldGen       total 10240K, used 6762K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 66% used [0x00000000fec00000,0x00000000ff29a8c0,0x00000000ff600000)
         Metaspace       used 3206K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 346K, capacity 388K, committed 512K, reserved 1048576K
        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];
        byte[] bytes3 = new byte[2 * size];
        byte[] bytes4 = new byte[2 * size];
        */

        /*
        [GC (Allocation Failure) [PSYoungGen: 5947K->744K(9216K)] 5947K->4848K(19456K), 0.0021182 secs] [Times: user=0.06 sys=0.02, real=0.00 secs]
        Hello GC Log !
        Heap
         PSYoungGen      total 9216K, used 7211K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 78% used [0x00000000ff600000,0x00000000ffc50da8,0x00000000ffe00000)
          from space 1024K, 72% used [0x00000000ffe00000,0x00000000ffeba020,0x00000000fff00000)
          to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         Metaspace       used 3214K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 348K, capacity 388K, committed 512K, reserved 1048576K

          没有发生Full GC：因为JVM默认当新生代没有足够的空间分配给待分配的对象是，该对象直接分配至老年代
        */
        byte[] bytes1 = new byte[2 * size];
        System.out.println("--------byte1---------");
        byte[] bytes2 = new byte[2 * size];
        System.out.println("--------byte2---------");
        byte[] bytes3 = new byte[3 * size];
        System.out.println("--------byte3---------");
        byte[] bytes4 = new byte[3 * size];
        System.out.println("Hello GC Log !");
    }
}
