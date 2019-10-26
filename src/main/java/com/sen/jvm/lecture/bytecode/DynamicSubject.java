package com.sen.jvm.lecture.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: Sen
 * @Date: 2019/10/26 21:45
 * @Description: 动态代理
 */
public class DynamicSubject implements InvocationHandler {

    private RealSubject realSubject;

    public DynamicSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy:" + method);
        method.invoke(realSubject, args);
        System.out.println("After proxy:" + method);
        return null;
    }
}
