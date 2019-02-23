package com.finedo.jvm.classloader;
/*
    当一个接口在初始化时，并不要求其父类接口都完成了初始化
    只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
 */
import java.util.Random;

public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }

}

interface MyParent5 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked");
        }
    };

}

class MyChild5 implements MyParent5 {
    public static int b = 5;
}
