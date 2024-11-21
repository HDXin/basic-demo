package top.atstudy.basic.thread;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadDemo {

    public static void main(String[] args) {

        ThreadLocal<TokenVO> t = new ThreadLocal<>();





    }


    @Data
    public static class TokenVO {

        private Integer userId;

        private String userName;

    }


    public static void test01(){

        ExecutorService taskExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        FutureTask<Integer> task = new FutureTask(() -> {

            return 1;
        });


        Future submit = taskExecutor.submit(task);



    }


}
