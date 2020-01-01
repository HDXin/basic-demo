package top.atstudy.basic.thread.park01.threadmethod;

import java.util.concurrent.TimeUnit;

public class DaemonThread01 {


    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " running ... ");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();

        System.out.println(Thread.currentThread().getName());
    }


}
