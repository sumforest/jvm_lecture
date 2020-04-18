package com.sen.jvm.lecture.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Sen
 * @Date: 2020/1/8 01:15
 * @Description: 让元空间先OOM
 * 设置虚拟机参数：
 * 设置最大值不让元空间扩容
 * -XX:MaxMetaspaceSize=9m -XX:+TraceClassLoading
 * 抛出异常：
 * java.lang.OutOfMemoryError: Metaspace
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            //使用Cglib动态生成类
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, arg1s, proxy) -> proxy.invokeSuper(obj, arg1s));
            System.out.println("Hello World!");
            // TimeUnit.MILLISECONDS.sleep(1000);
            enhancer.create();
        }
    }
}
