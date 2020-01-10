package top.atstudy.basic.thread.park03.newstructure.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 10:22
 */
public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.print("Latch barrier passed for " + this);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return String.format("WaitingTask ", id);
    }
}
