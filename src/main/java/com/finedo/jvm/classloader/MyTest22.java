package com.finedo.jvm.classloader;

public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(Mytest1.class.getClassLoader());
    }
}
