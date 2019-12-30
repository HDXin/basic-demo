package top.atstudy.basic.juc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：现在两个线程，可以操作初始值为0的一个变量
 * 实现多个线程对该变量 +1，多个线程对该变量 -1
 * 实现交替， 来20轮，变量初始值为零
 * 1、高内聚低耦合前提下，线程操作资源类
 * 2、判断/干活/通知
 * 3、防止虚假唤醒
 * 知识小总结 = 多线程编程套路 + while判断 + 新版写法
 */
public class AirconditionNew {

    private Integer nums = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {

        lock.lock();
        try{
            //1、判断
            while (nums != 0){
                condition.await();
            }

            //2、干活
            nums++;
            System.out.println(Thread.currentThread().getName() + "生成一个, 现有: " + nums);

            //3、通知
            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {

        lock.lock();
        try {
            //1、判断
            while (nums == 0){
                condition.await();
            }

            //2、干活
            nums--;
            System.out.println(Thread.currentThread().getName() + "消费一个, 剩余: " + nums);

            //3、通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        AirconditionNew aircondition = new AirconditionNew();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aircondition.increment();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aircondition.increment();
            }
        }, "AB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aircondition.decrement();
            }
        }, "BA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                aircondition.decrement();
            }
        }, "BB").start();
    }

}
