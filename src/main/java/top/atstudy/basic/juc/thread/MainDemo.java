package top.atstudy.basic.juc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainDemo {

    private Integer count = 0;

    public synchronized void syncIncreament() {
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count++;
    }

    public void increament() {
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count++;
    }

    public Integer getCount() throws InterruptedException {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        MainDemo demo = new MainDemo();

        Runnable r = () -> {
            demo.syncIncreament();
        };

        Runnable r2 = () -> {
            demo.increament();
        };

        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(r);
            Thread t2 = new Thread(r2);
            Thread t3 = new Thread(r2);

            ts.add(t);
            ts.add(t2);
            ts.add(t3);

            t.start();
            t2.start();
            t3.start();
        }


        for (Thread t:ts){
            t.join();
        }

        System.out.println(demo.getCount());




    }

}
