package com.finedo.jvm.classloader;

public class MyTest7 {
    public static void main(String[] args) throws Exception{
         Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2  = Class.forName("com.finedo.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());
}

}
class C {

}
