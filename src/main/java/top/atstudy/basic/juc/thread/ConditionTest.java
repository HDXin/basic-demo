package top.atstudy.basic.juc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 备注：多线程之间按顺序调用， 实现 A -> B -> C
 * 三个线程启动，要求如下：
 * AA 打印5次，BB 打印10次，CC 打印15次
 * 接着
 * AA 打印5次，BB 打印10次，CC 打印15次
 * 依次进行10轮
 */
public class ConditionTest {


    public static void main(String[] args) {
        ShareData data = new ShareData();

        new Thread(() -> {data.print5();}, "AA").start();
        new Thread(() -> {data.print10();}, "BB").start();
        new Thread(() -> {data.print15();}, "CC").start();

    }

}

class ShareData{

    //A:1, B:2, C:3
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //1、判断
            while (number != 1){
                c1.await();
            }

            //2、干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //3、通知
            number = 2;
            //如何通知第二个线程
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            //1、判断
            while (number != 2){
                c2.await();
            }

            //2、干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //3、通知
            number = 3;
            //如何通知第二个线程
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            //1、判断
            while (number != 3){
                c3.await();
            }

            //2、干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //3、通知
            number = 1;
            //如何通知第二个线程
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
