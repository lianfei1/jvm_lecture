package com.finedo.jvm.classloader;
/*
  关于命名空间的重要说明
  1.子加载器所加载的类能够访问到父加载器所加载的类
  2.父加载器所加载的类无法访问到子加载器所加载的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.finedo.jvm.classloader.MySample");

        System.out.println("clazz:" + clazz.hashCode());
        //如果注释该行，那么并不会实例化MySample对象，即MySample对象不会被调用，
        //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat.class
        Object object = clazz.newInstance();

    }
}
