package com.finedo.jvm.classloader;
/*
对于静态字段来说，只有直接定义了该字段的类才会被初始化；
当一个类在初始化时，要求其父类全部都已经初始化完毕了
 */
public class Mytest1 {
    public static void main(String[] args) {
            System.out.println(MyChild1.str); // 运行结果 MyParent1 static block hello world
           // System.out.println(MyChild1.str2); //运行结果 MyParent1 static block MyChild1 static block welcome
    }
}

class MyParent1 {

    public static  String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
