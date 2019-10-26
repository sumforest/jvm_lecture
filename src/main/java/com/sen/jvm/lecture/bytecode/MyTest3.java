package com.sen.jvm.lecture.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 14:26
 * @Description: 异常分析
 * 1.由javap -verbose反编译命令中看出，test()方法中的args_size = 1方法中并没有传入任何参数，
 * 这是因为javac编译器在编译时给每一个方法的第一个参数的位置自动生成一个this参数代表着当前实例的对象，这样使得我们
 * 在方法内可以使用this关键字来访问当前对象的其他属性和方法。
 * 2.stack = 3,表示当前方法的执行的任何时刻操作数栈所能达到的最大深度为3。
 * 3.locals = 4，表示当前方法的局部变量为4其中包含方法参数列表传进来的参数列表this，定义的参数is、serverSocket
 * 以及catch块中的异常类型。其中catch块中由三个异常类型，而locals=4，因为Java中catch块中只有一个catch会被执行。
 * Java中的异常处理：
 *  1.java中的异常处理采用的异常表的处理方式。
 *  2.如果异常处理中存在finally块，那么catch字节码的后面都会被编译器添加一份关于finally块中的字节码。
 */
public class MyTest3 {

    public void test() throws FileNotFoundException,IOException,NullPointerException{
        try {
            InputStream is = new FileInputStream("this.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }


    }
}
