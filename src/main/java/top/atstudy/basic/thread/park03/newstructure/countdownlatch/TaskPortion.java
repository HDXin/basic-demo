package top.atstudy.basic.thread.park03.newstructure.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 10:16
 */
public class TaskPortion implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(new Random(47).nextInt(2000));
        System.out.print(this + " completed ");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
