package com.sen.jvm.lecture.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Auther: Sen
 * @Date: 2019/10/24 18:59
 * @Description:
 */
public class ClassLoaderTest21 {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:://localhost:3306", "root", "123456");
    }
}
