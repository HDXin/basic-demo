package top.atstudy.basic.collection.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ListClient {

    private static final Integer num = new Random().nextInt(47);

    public static void main(String[] args) throws InterruptedException {

//        List<Integer> list = new ArrayList<>(1000);
//        for (int i = 0; i < 100; i++) {
//            list.add(0, i);
//        }

//        list.add(100, 20);

        insert(10000000, 10);
    }


    private static void insert(int size, int count) throws InterruptedException {
        System.out.print("【");
        long mills = 0;
        for (int i = 0; i < count; i++) {
            System.gc();
            TimeUnit.MILLISECONDS.sleep(2000);

            long start = System.currentTimeMillis();
            List<Integer> list = new ArrayList<>(size + 1);
            for (int j = 0; j < size; j++) {
                list.add(j);
            }
            long end = System.currentTimeMillis();
            System.out.print((end - start) + " ");

            mills = mills + (end - start);
        }
        System.out.print("】");
        System.out.println(" avg:" + (mills / count));
        mills = 0;
        System.out.println();
        System.out.print("【");
        for (int i = 0; i < count; i++) {
            System.gc();
            TimeUnit.MILLISECONDS.sleep(200);

            long start = System.currentTimeMillis();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list.add(j);
            }
            long end = System.currentTimeMillis();

            System.out.print((end - start) + " ");

            mills = mills + (end - start);
        }
        System.out.print("】");
        System.out.println(" avg:" + (mills / count));
        System.out.println();


    }


}
