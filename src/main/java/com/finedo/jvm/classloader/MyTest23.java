package com.finedo.jvm.classloader;
/*
    在运行期，一个java类是由该类的完全限定名（binary name，二进制名）和用于加载改类的定义类加载器（defining loader）所共同决定的，
    如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件的字节码完全一样，并且从相同的e
    位置加载亦如此
 */

import sun.misc.Launcher;

/*
    在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果修改错了，提示如下错误信息：
    Error occurred during initialization of VM
    java/lang/NoClassDefFoundError: java/lang/Object
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /*
            内建与JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类，
            当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，
            这块特殊的机器码就叫做启动类加载器（Bootstrap）.

            启动类加载器并不是java类，而是其他的加载器都是java类，
            启动类加载器是特定于平台的机器指令，它负责开启整个加载过程。

            所有类加载器（除了启动类加载器）都是java类，不过，总归要有一个组件来加载第一个java类加载器，从而让整个加载过程能够顺利的进行下去，
            加载第一个纯java类加载器就是启动类加载器的职责。

            启动类加载器还会负责加载供jre正常运行所需要的基本组件，这包括java.util和java.lang包中的类等等。
         */

        System.out.println(ClassLoader.class.getClassLoader());

        //扩展类加载器与系统类加载器也是由启动类加载器加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("--------");
        //java -Djava.system.class.loader=com.finedo.jvm.classloader.MyTest16 com.finedo.jvm.classloader.MyTest23
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
