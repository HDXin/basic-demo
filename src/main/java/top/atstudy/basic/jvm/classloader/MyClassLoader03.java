package top.atstudy.basic.jvm.classloader;

import java.util.UUID;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * 注意：这里指的是将常量存放到了MyClassLocader03的常量池中，之后MyClassLoader03与Student2 就没有任何关系
 * 甚至，我们可以将Student2的.class文件删除
 */
public class MyClassLoader03 {

    public static void main(String[] args) {
        System.out.println(Student3.str2);
    }

}

class Person3 {
    public static String str = " hello person";
    static {
        System.out.println(" Person static ... ");
    }
}

class Student3 extends Person3 {
    public static final String str2 = UUID.randomUUID().toString();

    public static final short s = 127;
    public static final int i = -2;
    public static final int m = 6;

    static {
        System.out.println(" Student static ... ");
    }
}