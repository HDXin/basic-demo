package top.atstudy.basic.thread.park02.waitset;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 1、所有的线程都会有一个wait set, 用来存放调用了该对象wait方法之后进入block状态线程
 * 2、线程被notify之后，不一定立即得到执行
 * 3、线程从wait set中被唤醒顺序不一定是FIFO
 * 4、线程被唤醒后，必须重新唤醒锁
 */
public class WaitSetTest {

    private static final Object LOCK = new Object();

    public static void main(String[] args){

        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(() -> {
                synchronized (LOCK){
                    System.out.println(" begin ... ");
                    try {
                        Optional.of(Thread.currentThread().getName() + " will come to wait set .").ifPresent(System.out::println);
                        LOCK.wait();
                        System.out.println(" after ... ");
                        Optional.of(Thread.currentThread().getName() + " will come to wait set .").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, String.valueOf(i)).start();
        });

        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(() -> {
                synchronized (LOCK){
                    try {
                        LOCK.notify();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, String.valueOf(i)).start();
        });

    }


}
