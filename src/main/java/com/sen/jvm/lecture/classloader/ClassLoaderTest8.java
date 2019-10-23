package com.sen.jvm.lecture.classloader;


/**
 * @Auther: Sen
 * @Date: 2019/10/23 14:20
 * @Description: 在通过子类调用定义在父类的静态变量或者静态方法不会导致子类的初始化。
 */
public class ClassLoaderTest8 {

    public static void main(String[] args) {
        System.out.println(MyParent8.a);
        MyParent8.test();
    }
}
class MyParent8{

    static int a = 5;

    static {
        System.out.println("MyParent8 static block");
    }

    static void test(){
        System.out.println("hello");
    }
}

class MyChild8{

    static{
        System.out.println("MyChild8 static block");
    }
}