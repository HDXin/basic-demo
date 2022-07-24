package top.atstudy.basic.juc.collection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Object v = new Object();

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

        map.put("", v);


    }

}
