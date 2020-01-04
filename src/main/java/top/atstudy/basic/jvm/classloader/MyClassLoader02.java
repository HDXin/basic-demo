package top.atstudy.basic.jvm.classloader;

/**
 * 对于静态字段来说， 只有直接定义了该字段的类才会被初始化；
 * 当一个类被初始化时，要求其父类全部都已经被初始化完毕；
 * -XX:+TraceClassLoading 用于追踪类加载信息并打印出来；
 * -XX:+<option>, 表示开启option选项
 *     -<option>, 表示关闭option选项
 *     <option>=<value>, 表示将option选项设置为value
 */
public class MyClassLoader02 {

    public static void main(String[] args) {
        System.out.println(Student.str);
    }

}

class Person {
    public static String str = " hello person";
    static {
        System.out.println(" Person static ... ");
    }
}

class Student extends Person {
    public static  String str2 = "hello student";
    static {
        System.out.println(" Student static ... ");
    }
}