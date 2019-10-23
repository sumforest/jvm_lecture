package com.sen.jvm.lecture.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @Auther: Sen
 * @Date: 2019/10/23 23:47
 * @Description: 扩展类加载器演示
 */
public class ClassLoaderTest15_2 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(ClassLoaderTest15_2.class.getClassLoader());
        System.out.println(AESKeyGenerator.class.getClassLoader());
    }
}
