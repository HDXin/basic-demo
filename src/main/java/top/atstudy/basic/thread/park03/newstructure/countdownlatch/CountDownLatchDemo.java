package top.atstudy.basic.thread.park03.newstructure.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 10:25
 *
 * 注: 全部都执行完，才能结束
 *
 */
public class CountDownLatchDemo {
    private static final int SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);

//        for(int i=0; i<SIZE/2; i++){
//            exec.execute(new WaitingTask(latch));
//        }
//
//        for(int i=0; i<SIZE/2; i++){
//            exec.execute(new TaskPortion(latch));
//        }
        Runnable t = () -> {
            int a = new Random().nextInt(20);
            try {
                TimeUnit.MILLISECONDS.sleep(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" dowork ... " + a);
            latch.countDown();
        };

        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            exec.submit(t);
        }
        latch.await();
        long end = System.currentTimeMillis();

        System.out.println(" Launched all tasks: " + (end - start));
        exec.shutdownNow();
    }

}
