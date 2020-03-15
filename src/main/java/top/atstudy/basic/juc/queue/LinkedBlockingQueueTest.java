package top.atstudy.basic.juc.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

    public static void main(String[] args) {


        System.out.println(Runtime.getRuntime().availableProcessors());

//        demo();

    }

    private static void demo() throws InterruptedException {

        int size = 5;
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(size);


    }

}
