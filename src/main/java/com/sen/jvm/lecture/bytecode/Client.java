package com.sen.jvm.lecture.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 21:48
 * @Description:
 */
public class Client {

    public static void main(String[] args) {

        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject realSubject = new RealSubject();
        InvocationHandler invocate = new DynamicSubject(realSubject);
        Class<? extends RealSubject> clazz = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader()
                , clazz.getInterfaces(), invocate);

        subject.required();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
