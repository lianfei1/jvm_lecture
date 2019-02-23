package com.finedo.jvm.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}
//调用ClassLoader类的loadclass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
public class MyTest12 {
    public static void main(String[] args) throws Exception{
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.finedo.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("---------------");
        clazz = Class.forName("com.finedo.jvm.classloader.CL");
        System.out.println(clazz);
    }
}
