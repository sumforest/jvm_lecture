package com.sen.jvm.lecture.bytecode;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 16:39
 * @Description: 方法重载与静态分派
 * Grandpa g1 = new Father();
 * 以上代码中，g1的静态类型是Grandpa，实际类型（指向的对象）是Father
 * 结论：变量的静态类型是不可以改变的，而实际类型则是可以改变的，（多态的体现），实际类型是在运行期确定。
 */
public class MyTest5 {
    //方法重载，是一种静态行为，是编译期就可以完全确定的。
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void teset(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        //以下都输出grandpa
        myTest5.test(g1);
        myTest5.test(g2);
    }
}

class Grandpa{

}

class Father extends Grandpa{

}

class Son extends Father{

}