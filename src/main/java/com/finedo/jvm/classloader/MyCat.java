package com.finedo.jvm.classloader;

public class MyCat {
    public MyCat() {
        System.out.println("mycat loader :" + this.getClass().getClassLoader());

        //System.out.println("from MySample: " + MySample.class);

    }
}
