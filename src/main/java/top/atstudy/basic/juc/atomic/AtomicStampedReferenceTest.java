package top.atstudy.basic.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

    public static void main(String[] args) {

        //ABA问题
//        demo();

        //解决ABA问题
        demo2();


    }

    /**
     * ABA问题解决
     */
    private static void demo2(){
        AtomicStampedReference<Integer> atomic = new AtomicStampedReference<>(100, 1);

        new Thread(() -> {
            int version = atomic.getStamp();
            int value = atomic.getReference();
            System.out.println(Thread.currentThread().getName() + " value:" + value + ", version:" + version);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {}

            atomic.compareAndSet(100, 101, version, ++version);
            int version2 = atomic.getStamp();
            int value2 = atomic.getReference();
            System.out.println(Thread.currentThread().getName() + " value:" + value2 + ", version:" + version2);

            atomic.compareAndSet(101, 100, version2, ++version2);
            int version3 = atomic.getStamp();
            int value3 = atomic.getReference();
            System.out.println(Thread.currentThread().getName() + " value:" + value3 + ", version:" + version3);

        }, "t-1").start();

        new Thread(() -> {
            int version = atomic.getStamp();
            int value = atomic.getReference();
            System.out.println(Thread.currentThread().getName() + " value:" + value + ", version:" + version);
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {}

            boolean flag = atomic.compareAndSet(100, 101, version, version++);
            System.out.println(flag);
            int version2 = atomic.getStamp();
            int value2 = atomic.getReference();
            System.out.println(Thread.currentThread().getName() + " value:" + value2 + ", version:" + version2);

        }, "t-2").start();

    }


    /**
     * ABA问题
     *  t-1: 100 -> 101
     *       101 -> 100
     *  2秒后
     *  t-2: 100 -> 102
     *
     */
    private static void demo(){

        AtomicReference<Integer> atomic = new AtomicReference<>(100);

        new Thread(() -> {
            Integer start = atomic.get();
            atomic.compareAndSet(100, 101);
            System.out.println(Thread.currentThread().getName() + ": " + start + " -> " + atomic.get());
            atomic.compareAndSet(101, 100);
            System.out.println(Thread.currentThread().getName() + ": 101 -> "  + atomic.get());
        }, "t-1").start();

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer start = atomic.get();
            System.out.println(Thread.currentThread().getName() + ": " + start);
            atomic.compareAndSet(100, 102);
            System.out.println(Thread.currentThread().getName() + ": " + start + " -> " + atomic.get());
        }, "t-2").start();



    }

}
