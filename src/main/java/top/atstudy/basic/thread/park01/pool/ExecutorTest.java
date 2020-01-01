package top.atstudy.basic.thread.park01.pool;

import top.atstudy.basic.thread.park01.task.LiftOff;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/1 16:51
 */
public class ExecutorTest {

    public static void main(String[] args) {

        //创建与任务数相同线程数的线程池
//        create01();

        //指定线程数的线程池
//        create02();

        //单线程数的线程池
        create03();

    }

    /**
     * 线程池
     */
    private static void create01(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=1; i<=3; i++){
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
        for(int i=0; i<5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

    /**
     * 容量为1的线程池
     */
    public static void create03() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i=0; i<3; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }


}
