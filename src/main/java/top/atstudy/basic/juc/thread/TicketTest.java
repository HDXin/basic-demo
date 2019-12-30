package top.atstudy.basic.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketTest {

    private int nums = 50;

    private Lock lock = new ReentrantLock();

    public void sale(){

        lock.lock();
        try {
            if(nums > 0){
                System.out.println(Thread.currentThread().getName() + "卖第" + nums-- + "张票， 剩余：" + nums + "张");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) {

        TicketTest ticket = new TicketTest();

        new Thread(() ->{ for (int i=0; i<50; i++) ticket.sale();}, "AA").start();
        new Thread(() ->{ for (int i=0; i<50; i++) ticket.sale();}, "BB").start();
        new Thread(() ->{ for (int i=0; i<50; i++) ticket.sale();}, "CC").start();

    }

}
