package top.atstudy.basic.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        demo();

    }


    private static void demo(){

        int size = Runtime.getRuntime().availableProcessors();
        //固定数
//        ExecutorService service = Executors.newFixedThreadPool(size);
        //单线程
//        ExecutorService service = Executors.newSingleThreadExecutor();
        //可扩容的
        ExecutorService service = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < size * 1000; i++) {
                service.submit(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 窗口处理业务 ... ");
                });
            }
        } catch (Exception e){

        } finally {
            service.shutdown();
        }

    }

}
