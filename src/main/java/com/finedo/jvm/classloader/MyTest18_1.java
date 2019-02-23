package com.finedo.jvm.classloader;

public class MyTest18_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");

        Class<?> clazz = loader1.loadClass("com.finedo.jvm.classloader.Mytest1");

        System.out.println("class: " +clazz.hashCode());
        System.out.println("class loader" + clazz.getClassLoader());
    }
}
