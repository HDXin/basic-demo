package top.atstudy.basic.juc.thread;

import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService taskService = Executors.newFixedThreadPool(5);

        Long start = System.currentTimeMillis();
        List<Future<Integer>> list = new ArrayList<>(1000);
        for (int i = 0; i < 5; i++) {

            list.add(taskService.submit(() -> {
                int sleep = RandomUtil.randomInt(5000, 10000);
                Thread.sleep(sleep);
                System.out.println(" --->> sleep: " + sleep);


                int a = RandomUtil.randomInt(1, 100);

                System.out.println(Thread.currentThread().getName() + ", " + a);
                return a;
            }));
        }
        System.out.println(" ======= ");

        int sum = 0;
        for (Future<Integer> item : list) {
            int temp = item.get();
            sum += temp;
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println(" ==>> sum: " + sum);
        System.out.println(" ==>> sum: " + sum);
    }

}
