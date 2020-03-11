package top.atstudy.basic.juc.atomic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public static void main(String[] args) {

//        demo();

//        demo02();

        demo03();

    }

    private static void demo(){
        AtomicInteger a = new AtomicInteger(1);
        for (int i = 0; i < 10; i++) {
            Integer b = a.addAndGet(1);
            System.out.print(b + " ");
        }
        System.out.println();
    }

    private static void demo02() {
        AtomicInteger a = new AtomicInteger(100);

        Map<String, List<Integer>> resultMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                resultMap.put(Thread.currentThread().getName(), new CopyOnWriteArrayList<>());

                for (int j = 0; j < 30; j++) {
//                    int result = a.addAndGet(1);
                    int result = a.incrementAndGet();
                    try { TimeUnit.MILLISECONDS.sleep(20); } catch (InterruptedException e) { }

                    resultMap.get(Thread.currentThread().getName()).add(result);
                }
            }, "t-" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resultMap.forEach((key, value) -> {
            System.out.print(key + " ");
            value.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }


    private static void demo03(){

        AtomicInteger a = new AtomicInteger(1);
        a.addAndGet(1);


        AtomicInteger b = new AtomicInteger(10);
        b.addAndGet(5);

        AtomicInteger c = new AtomicInteger(25);
        c.addAndGet(3);

    }

}
