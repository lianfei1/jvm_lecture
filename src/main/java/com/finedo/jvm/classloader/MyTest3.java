package com.finedo.jvm.classloader;

import java.util.UUID;
/*
当一个常量的值并非编译期可以确定的，那么其值就不会被放到调用类的常量池中，这时程序运行时，会导致主动使用
这个常量池所在的类，显然会导致这个类被初始化。
 */
public class MyTest3 {
    public static void main(String[] args) {

        System.out.println(MyPatent3.str);
    }
}

class MyPatent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}
