package top.atstudy.basic.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
