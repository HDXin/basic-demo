package top.atstudy.basic.collection;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/2/26 17:18
 */
public class HashMapTest {

    @Test
    public void NewHashMapPutTest(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Java", "hello world");
        map.put("C#", "哈哈");
        map.put("C++", "hiahia");
        System.out.println(map.toString());
    }

    @Test
    public void NewHashMapComparableClassForTest(){
        HashMap<String, String> map = new HashMap<>();



    }

    @Test
    public void hashMapTableSizeFor(){
//        System.out.println(tableSizeFor(1));
//        System.out.println(tableSizeFor(3));
//        System.out.println(tableSizeFor(7));
//        System.out.println(tableSizeFor(15));
//        System.out.println(tableSizeFor(55));
//        System.out.println(tableSizeFor(88));
        System.out.println(tableSizeFor(100));


        System.out.println(100 >>> 2);


    }


    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


}
