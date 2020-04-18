package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 14:57
 * @Description: 获取类加载器的所有双亲加载器
 */
public class ClassLoaderTest10 {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);

        // 在Oracle的jvm中null表示根类加载器
        while (loader != null) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
