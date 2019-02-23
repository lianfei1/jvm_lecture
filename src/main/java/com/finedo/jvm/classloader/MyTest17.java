package com.finedo.jvm.classloader;

public class MyTest17 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("com.finedo.jvm.classloader.MySample");

        System.out.println("clazz:" + clazz.hashCode());
        //如果注释该行，那么并不会实例化MySample对象，即MySample对象不会被调用，
        //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat.class
        Object object = clazz.newInstance();

    }


}
