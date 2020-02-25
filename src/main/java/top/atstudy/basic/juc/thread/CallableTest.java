package top.atstudy.basic.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第一种：实现 Runnable 接口
 * 第二种：继承 Thread 类
 * 第三种：获取线程的方式
 * 第四种：
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        new Thread(task, "AA").start();

        Integer result = task.get();
        System.out.println("result: " + result);

    }

}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("hello callable ... ");

        return 1024;
    }
}
