package top.atstudy.basic.thread.executor;

import top.atstudy.basic.thread.task.LiftOff;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/1 16:51
 */
public class MyExecutor {

    /**
     * 线程池
     * @param args
     */
//    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for(int i=0; i<3; i++){
//            exec.execute(new LiftOff());
//        }
//        exec.shutdown();
//    }

    /**
     * 指定容量的线程池
     * @param args
     */
//    public static void main(String[] args) {
//        Integer THREAD_POOL_SIZE = 3;
//        ExecutorService exec = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        for(int i=0; i<THREAD_POOL_SIZE; i++){
//            exec.execute(new LiftOff());
//        }
//        exec.shutdown();
//    }

    /**
     * 容量为1的线程池
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i=0; i<3; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

}
