package com.sen.jvm.lecture.bytecode;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 19:24
 * @Description: 现在JVM在执行Java代码的时候，通常都会将解析执行于编译执行二者结合起来。
 * 	1.所谓解释执行，就是通过解释器来读取字节码，遇到相应的指令就去执行该指令。
 * 	2.所谓编译执行，就是通过即使编译期（Just In Time，JIT）将字节码转换为本地机器码来执行；现代JVM会根据代码热点来生成。
 * 	基于栈的指令集于基于寄存器的指令集之间的关系：
 * 	    i. JVM执行指令是所采取的方式是基于栈的指令集。
 * 	    ii. 基于栈的指令集主要的操作有入栈和出栈两种。
 * 	    iii. 基于栈的指令集的优势在于它可以在不同平台之间移植，而基于寄存器的指令集是于硬件紧密相关的，无法做到可移植。
 * 	    iv. 基于栈的指令集的缺点在于完成相同的操作，指令数量通常要比基于寄存器的指令集数量要多；基于栈的指令集是在内存
 * 	        中完成操作的，而基于寄存器的指令集是直接有CPU来执行的，它是在高速缓冲区中进行操作的，速度要快很多。
 * 	        虽然虚拟机可以采用一次额优化手段，但总体来说基于栈的指令集的速度要慢一些。
 */
public class MyTest8 {

    public int add() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int result = (a + b - c) * d;
        return result;
    }
}
