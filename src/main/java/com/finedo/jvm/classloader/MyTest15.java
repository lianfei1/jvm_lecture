package com.finedo.jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        /*
        this class loader is bootstrap class loader
         */
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());


        /*
        if the element type is a primitive type, then the array class has no
        class loader.
         */
        int[] i = new int[2];
        System.out.println(i.getClass().getClassLoader());
    }
}
