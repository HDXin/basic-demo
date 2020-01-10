package top.atstudy.basic.thread.park03.newstructure.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 11:01
 */
public class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b){
        barrier = b;
    }

    public synchronized int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e2){
            e2.printStackTrace();
            throw new RuntimeException(e2);
        }
    }

    @Override
    public String toString(){
        return "Horse " + id + " ";
    }

    public String tracks(){
        StringBuilder s = new StringBuilder();
        for(int i=0; i<getStrides(); i++){
            s.append("*");
        }
        s.append(id);
        return  s.toString();
    }
}
