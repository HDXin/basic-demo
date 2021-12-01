package top.atstudy.basic.juc.thread;

import cn.hutool.core.util.RandomUtil;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 解释：人都走完了才能锁门
 * CountDownLatch:
 * count: 计数器
 * .countDown(): 没执行一次，计数器减一（-1）
 * .await():
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        demo();

    }


    private static void demo() throws InterruptedException {
        int poolSize = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(poolSize);
        CountDownLatch latch = new CountDownLatch(poolSize);

        Runnable r = () -> {
            int sleep = RandomUtil.randomInt(1, 21);
            try {
                TimeUnit.MILLISECONDS.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" ===>> " + Thread.currentThread().getName() + " dowork:" + sleep);
            latch.countDown();
        };
        for (int i = 0; i < poolSize; i++) {
          service.submit(r);
        }

        latch.await();
        System.out.println(" all work");

    }


}
