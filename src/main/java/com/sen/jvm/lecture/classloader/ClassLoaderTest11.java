package com.sen.jvm.lecture.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 15:02
 * @Description:
 */
public class ClassLoaderTest11 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String src = "com/sen/jvm/lecture/classloader/ClassLoaderTest11.class";

        Enumeration<URL> urls = classLoader.getResources(src);

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

    }
}
