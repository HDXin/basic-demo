package top.atstudy.basic.juc.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ConcurrentModificationException
 */
public class ArrayListTest {

    public static void main(String[] args) {

        //ArrayList
//        arrayList01();

        //Vector
//        arrayList02();

        //
//        arrayList03();

        //
        arrayList04();


    }

    /**
     * 多线程操作 ArrayList
     * 出现异常：java.util.ConcurrentModificationException
     */
    public static void arrayList01(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));

                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * Vector 是线程安全的
     */
    public static void arrayList02(){
        List<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));

                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public static void arrayList03(){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));

                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public static void arrayList04(){
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));

                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

}
