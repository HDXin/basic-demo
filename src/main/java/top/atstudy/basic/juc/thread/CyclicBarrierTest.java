package top.atstudy.basic.juc.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 解释：人到齐了就开会
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        demo();

    }

    private static void demo(){

        int size = Runtime.getRuntime().availableProcessors();
        CyclicBarrier barrier = new CyclicBarrier(size, ()-> System.out.println("人已到齐，会议开始"));

        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 已到会议室");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "t-" + i).start();
        }

    }


}
