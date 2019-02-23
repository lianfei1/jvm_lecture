package com.finedo.jvm.classloader;

public class MySample {
    public MySample() {
        System.out.println("MySample loader :" + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("from mycat:" + MyCat.class);
    }
}
