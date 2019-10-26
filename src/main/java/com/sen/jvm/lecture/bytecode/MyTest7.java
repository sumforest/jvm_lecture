package com.sen.jvm.lecture.bytecode;

import java.util.Date;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 18:22
 * @Description:
 */
public class MyTest7 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal{
    public void test(String string) {
        System.out.println("Animal");
    }

    public void test(Date date) {
        System.out.println("Animal Date");
    }
}

class Dog extends Animal {
    @Override
    public void test(String string) {
        System.out.println("dog");
    }

    @Override
    public void test(Date date) {
        System.out.println("dog data");
    }
}