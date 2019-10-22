package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 22:09
 * @Description: 常量在编译期会存入到调用的方法所在的类的常量池中，本质上并没用调用到定义该常量的类，所以
 * 该类并不会被初始化。
 * 注意：这里的常量值已存放到调用该常量的方法的类的常量池中与定义该常量的类已经没有关系了，甚至可以把定义
 * 该常量的类的.class文件删除也能正常运行。
 *
 * 	助记符：
 * 	ldc表示将int，float，或是String类型的常量值从常量池推送至栈顶。
 * 	bipush表示将单字节（-128~127）的常量值推送至栈顶
 * 	sipush表示将一个短整型常量值（-32768~32767）推送至栈顶
 * 	iconst_1表示将int类型1推送至栈顶（iconst_1~iconst_5）
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.NUM1);
    }
}
class MyParent2{

    public static final String STRING = "hello world";

    public static final short SHORT = 7;

    public static final int NUM1 = 6;

    static {
        System.out.println("MyParent2 inits");
    }
}
