package top.atstudy.basic.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    private static void demo() throws InterruptedException {
        int size = 5;
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(size);

        int nums = 5;
        for (int i = 0; i < nums; i++) {

            //队列已满时，抛出异常
//            blockingQueue.add(i);

            //当队列已满时，直接返回
//            blockingQueue.offer(i);
            //当队列已满时，阻塞相应时间后，
            blockingQueue.offer(i, 2, TimeUnit.SECONDS);

            //当队列已满时，阻塞等待，直到插入为止
//            blockingQueue.put(i);
        }

        for (int i = 0; i < 10; i++) {
            //没有时，立即返回 null
//            System.out.println(blockingQueue.poll());

            //有时立即返回，没有时，阻塞后返回
//            System.out.println(blockingQueue.poll(1, TimeUnit.SECONDS));

            //有时立即返回，没有时阻塞知道人返回数据
            System.out.println(blockingQueue.take());

        }


    }

}
