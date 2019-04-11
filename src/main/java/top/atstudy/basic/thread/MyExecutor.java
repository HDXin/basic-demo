package top.atstudy.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/1 16:51
 */
public class MyExecutor {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        MyRunnable r = new MyRunnable();
        for(int i=0; i<5; i++){
            exec.execute(r);
        }

        exec.shutdown();
    }

}
