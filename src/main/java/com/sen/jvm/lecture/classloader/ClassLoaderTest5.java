package com.sen.jvm.lecture.classloader;

import java.util.Random;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 00:48
 * @Description: 1.当一个接口初始化并不要求其父接口进行初始化。
 * 2.只有真正的使用到父接口的时候（如：如接口中所定义的常量是运行时才去确定的常量时或者方法），父接口才会
 *   被初始化。
 */
public class ClassLoaderTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }

}
interface MyParent5{
    int a = new Random().nextInt(4);
    int c = 1 / 0;
}

interface MyChild5 extends MyParent5{
    int b = new Random().nextInt(8);
}
