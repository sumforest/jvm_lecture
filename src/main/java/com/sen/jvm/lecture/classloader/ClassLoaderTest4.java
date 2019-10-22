package com.sen.jvm.lecture.classloader;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 23:13
 * @Description: 创建引用类型的数组时，其类型是由JVM编译时生成的，表示为[Lcom.sen.jvm.lecture.
 * classloader.MyParent4 这种形式。是动态生成的类型，其父类型是object，所以不会主动使用定义数组类型的类，
 * 该类不会初始化。
 * 对于数据来说，JavaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后的类型。
 * 助记符：
 *  1.anewarray 表示创建一个引用类型（如：类、接口、数组）数组，并将其引用值压入栈顶。
 *  2.multianewarry 表示创建一个引用类型的二维数组，并将其引用值压入栈顶。
 *  3.newarray 表示创建一个指定原始类型数组，并将其引用值压入栈顶。
 */
public class ClassLoaderTest4 {
    public static void main(String[] args) {
        // MyParent4 myParent4 = new MyParent4();
        // System.out.println("========");
        // MyParent4 myParent4s = new MyParent4();

        MyParent4[] myParents = new MyParent4[1];
        System.out.println(myParents.getClass());
        System.out.println(myParents.getClass().getSuperclass());

        MyParent4[][] myParent4s = new MyParent4[1][1];
        System.out.println(myParent4s.getClass());

        int[] array = new int[1];
        System.out.println(array.getClass());
    }
}
class MyParent4{
    static {
        System.out.println("MyParent inits");
    }
}