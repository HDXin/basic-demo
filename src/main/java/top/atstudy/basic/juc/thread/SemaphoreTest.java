package top.atstudy.basic.juc.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 解释：午休时间，抢沙发，多个人抢多个资源
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        demo();

    }

    private static void demo(){

        int size = 5;
        Semaphore semaphore = new Semaphore(size);

        int p = 37;
        for (int i = 0; i < p; i++) {
            final int temp = i;
            new Thread(() -> {
                //抢到资源
                try {
                    semaphore.acquire();
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    long sleep = new Random().nextInt(10) + 1;
                    TimeUnit.SECONDS.sleep(sleep);
                    System.out.println(" ==>> " + date + " " + temp + " 号员工抢到了沙发， 使用了：" + sleep + "（秒）");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放资源
                    semaphore.release();
                }
            }, "t-" + i).start();
        }
    }

}
