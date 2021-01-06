package top.atstudy.basic.thread.park01.pool;

import top.atstudy.basic.thread.park01.task.LiftOff;

import java.util.concurrent.*;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/1 16:51
 */
public class ExecutorTest {

    public static void main(String[] args) {

        // 创建与任务数相同线程数的线程池
//        create01();

        // 指定线程数的线程池
//        create02();

        // 单线程数的线程池
//        create03();

        //
        test04();

    }

    /**
     *
     */
    private static void test04() {

        final int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(" ===>> processors: " + processors);
        final ThreadPoolExecutor exec = new ThreadPoolExecutor(processors,
                30,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 1030; i++) {
            exec.submit(new MyTask(), "task-" + i);
        }

        new Thread(() -> {
            while (true) {
                System.out.println("getActiveCount: " + exec.getActiveCount());
                System.out.println("getPoolSize: " + exec.getPoolSize());
                System.out.println("getCompletedTaskCount: " + exec.getCompletedTaskCount());
                System.out.println("getCorePoolSize: " + exec.getCorePoolSize());
                System.out.println("getKeepAliveTime: " + exec.getKeepAliveTime(TimeUnit.SECONDS));
                System.out.println("getLargestPoolSize: " + exec.getLargestPoolSize());
                System.out.println("getMaximumPoolSize: " + exec.getMaximumPoolSize());
                System.out.println("getTaskCount: " + exec.getTaskCount());
                System.out.println("--------------------------------------------------------------------------");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 线程池
     */
    private static void create01() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= 3; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    /**
     * 指定容量的线程池
     */
    public static void create02() {
        Integer THREAD_POOL_SIZE = 3;
        ExecutorService exec = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    /**
     * 容量为1的线程池
     */
    public static void create03() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }


}
