package com.sen.jvm.lecture.bytecode;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 17:21
 * @Description: 方法动态分派机制
 * 方法重载（overload）和方法从写（override）的区别：方法重载是发给发静态分派机制，在编译期确定；方法重写是动态分派
 * 机制，在运行期确定。
 */
public class MyTest6 {

    public static void main(String[] args) {
        Fruits apple = new Apple();
        Fruits orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}
class Fruits{
    public void test() {
        System.out.println("fruits");
    }
}

class Apple extends Fruits {
    @Override
    public void test() {
        System.out.println("apple");
    }
}

class Orange extends Fruits{
    @Override
    public void test() {
        System.out.println("orange");
    }
}