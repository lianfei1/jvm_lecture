package com.finedo.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends  ClassLoader {
    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    public MyTest16(String classLoaderName) {
        super();//将系统类加载器当做该类加载器的父类加载器
        this.classLoaderName = classLoaderName;
    }



    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//显示指定该类加载器的父级加载器

        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName  +"]";
    }

    protected  Class<?> findClass(String classLoaderName) {
        System.out.println("findClass invoke:" + classLoaderName);
        System.out.println("class loader name: " +this.classLoaderName);
        byte[] data = this.loadClassDate(classLoaderName);
        return this.defineClass(classLoaderName,data, 0,data.length);
    }

    private byte[] loadClassDate(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".","\\");

        try{
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.finedo.jvm.classloader.Mytest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");
        clazz = loader1.loadClass("com.finedo.jvm.classloader.Mytest1");
        System.out.println("class:" + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);




        //MyTest16 loader2 = new MyTest16("loader2");
        /*MyTest16 loader2 = new MyTest16(loader1,"loader2");
        loader2.setPath("C:\\Users\\Administrator\\Desktop\\");
        Class<?> clazz2 = loader2.loadClass("com.finedo.jvm.classloader.Mytest1");
        System.out.println("class:" + clazz2.hashCode());
        Object object2 = clazz.newInstance();

        System.out.println(object2);*/
    }



}
