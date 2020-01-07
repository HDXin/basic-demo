package top.atstudy.basic.jvm.gc;


/**
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 *
 * 终端输入：虚拟机默认参数
 * java -XX:+PrintCommandLineFlags -version
 */
public class MyGCTest03 {

    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;
        byte[] b = new byte[4 * size];
        System.out.println("11111");

        byte[] b2 = new byte[3 * size];
        System.out.println("22222");

        byte[] b3 = new byte[4 * size];
        System.out.println("33333");

        byte[] b5 = new byte[2 * size];
        System.out.println("55555");

    }




}
