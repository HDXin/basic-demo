package top.atstudy.basic.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * -verbose:gc
 * -Xms200m
 * -Xmx200m
 * -Xmn50m
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 *
 * 终端输入：虚拟机默认参数
 * java -XX:+PrintCommandLineFlags -version
 */
public class MyGCTest02 {

    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;

        byte[] b = new byte[3 * size];
        byte[] b2 = new byte[size];
        System.out.println("11111");
        myGc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("22222");
        myGc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("33333");
        myGc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("44444");
        myGc();
        TimeUnit.SECONDS.sleep(1);

        byte[] b5 = new byte[3 * size];
        byte[] b6 = new byte[3 * size];
        byte[] b7 = new byte[3 * size];

        System.out.println("55555");
        myGc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("66666");
        myGc();
        TimeUnit.SECONDS.sleep(1);

    }


     private static void myGc(){
         for (int i = 0; i < 40; i++) {
             byte[] b = new byte[1024*1024];
         }
     }

}
