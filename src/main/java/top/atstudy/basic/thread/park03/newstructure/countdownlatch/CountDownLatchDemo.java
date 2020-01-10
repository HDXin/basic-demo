package top.atstudy.basic.thread.park03.newstructure.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 10:25
 *
 *
 */
public class CountDownLatchDemo {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);

        for(int i=0; i<10; i++){
            exec.execute(new WaitingTask(latch));
        }

        for(int i=0; i<SIZE; i++){
            exec.execute(new TaskPortion(latch));
        }



        System.out.println(" Launched all tasks");
        exec.shutdownNow();
    }

}
