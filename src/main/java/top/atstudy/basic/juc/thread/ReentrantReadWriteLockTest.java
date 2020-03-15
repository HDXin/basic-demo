package top.atstudy.basic.juc.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {

//        demo();

//        demo2();

//        demo3();

//        demo4();

        demo5();
    }

    private static void demo5(){
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        writeLock.lock();
        System.out.println(" ===>> " + Thread.currentThread().getName());

        writeLock.lock();
        System.out.println(" ===>> " + Thread.currentThread().getName());

        Thread t = new Thread(() -> {
            writeLock.lock();
            System.out.println(" ===>> " + Thread.currentThread().getName());
        });

        t.start();

    }

    private static void demo4(){

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

//        for (int i = 0; i < 1; i++) {
//            new Thread(() -> {
//                readLock.lock();
//                System.out.println(" ===>> " + Thread.currentThread().getName());
//            }, "t-" + i).start();
//        }


        readLock.lock();
        System.out.println(" ===>> " + Thread.currentThread().getName());

        readLock.lock();
        System.out.println(" ===>> " + Thread.currentThread().getName());

//        new Thread(() -> {
//            readLock.lock();
//            System.out.println(" ===>> " + Thread.currentThread().getName());
//        }, "t-1").start();
//
//        new Thread(() -> {
//            readLock.lock();
//            System.out.println(" ===>> " + Thread.currentThread().getName());
//        }, "t-2").start();

    }

    /**
     * 读锁与读锁兼容
     * 读锁与写锁互斥
     * 写锁与写锁互斥
     */
    private static void demo3(){

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                writeLock.lock();
                System.out.println(" " + Thread.currentThread().getName() + " get write lock ...");

            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                readLock.lock();
                System.out.println(" " + Thread.currentThread().getName() + " get read lock ...");

            }).start();
        }

    }

    /**
     * 锁降级
     * 测试：
     * 写锁 -> 读锁
     *
     * 结论：写锁可以降级为读锁
     */
    private static void demo2(){

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        writeLock.lock();
        System.out.println(" " + Thread.currentThread().getName() + " get write lock ...");

        readLock.lock();
        System.out.println(" " + Thread.currentThread().getName() + " get read lock ...");
    }


    /**
     * 锁升级
     * 测试：
     * 读锁 -> 写锁
     *
     * 结论：读锁不能升级为写锁
     */
    private static void demo(){

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        readLock.lock();
        System.out.println(" " + Thread.currentThread().getName() + " get read lock ...");

        writeLock.lock();
        System.out.println(" " + Thread.currentThread().getName() + " get write lock ...");
    }

}
