package top.atstudy.basic.jvm.gc;

/**
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=4194304 对象超过阈值，直接在老年代分配内存
 * -XX:+UseSerialGC
 * -XX:MaxTenuringThreshold=5 设置晋升到老年代的对象的最大的存货年龄
 * -XX:+PrintTenuringDistribution
 *
 * 终端输入：虚拟机默认参数
 * java -XX:+PrintCommandLineFlags -version
 */
public class MyGCTest {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] b = new byte[10 * size];
//        byte[] b2 = new byte[3 * size];
//        byte[] b3 = new byte[3 * size];
//        byte[] b4 = new byte[3 * size];

        System.out.println("hello world");
    }

}
