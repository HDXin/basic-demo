package top.atstudy.basic.thread.park03;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static volatile int value = 0;

    public static void main(String[] args) {

//        test02();

    }

    private static void test02(){

        AtomicInteger i = new AtomicInteger();
        System.out.println(i.get());
        i = new AtomicInteger(10);
        System.out.println(i.get());

        //set
        i.set(15);
        System.out.println(i.get());

    }

    /**
     * 并发问题
     * @throws InterruptedException
     */
    private static void test01() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 50){
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value += 1;
                x++;

                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 50){
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value += 1;

                x++;

                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            int x = 0;
            while (x < 50){
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value += 1;

                x++;

                try {
                    TimeUnit.MILLISECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t3.start();
        t2.start();
        t1.start();

        t3.join();
        t2.join();
        t1.join();

        System.out.println(value);
    }
}
