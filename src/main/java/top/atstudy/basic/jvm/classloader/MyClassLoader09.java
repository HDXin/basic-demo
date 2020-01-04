package top.atstudy.basic.jvm.classloader;

public class MyClassLoader09 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());

    }

}
