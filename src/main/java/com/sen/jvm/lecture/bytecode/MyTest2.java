package com.sen.jvm.lecture.bytecode;

/**
 * @Author: Sen
 * @Date: 2019/10/25 23:10
 * @Description:
 */
public class MyTest2 {
    String str = "welcome";
    private int x = 5;
    public static Integer in = 10;

    public void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }
}
