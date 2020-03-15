package top.atstudy.basic.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) {

        demo();

    }


    private static void demo(){

        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = () -> {
            System.out.println("hiahia");
        };

        executorService.submit(runnable);

    }




}
