package top.atstudy.basic.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {

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

        Ticket ticket = new Ticket();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0; i<50; i++){
//                    ticket.sale();
//                }
//            }
//        }, "A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0; i<50; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0; i<50; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "C").start();


        new Thread(() ->{ for (int i=0; i<50; i++) ticket.sale();}, "AA").start();
        new Thread(() ->{ for (int i=0; i<50; i++) ticket.sale();}, "BB").start();
        new Thread(() ->{ for (int i=0; i<50; i++) ticket.sale();}, "CC").start();

    }

}
