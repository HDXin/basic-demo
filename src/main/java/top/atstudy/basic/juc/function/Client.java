package top.atstudy.basic.juc.function;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client {

    /**
     * 拷贝小括号、写死右箭头、落地大括号
     * @param args
     */
    public static void main(String[] args) {

        testDemo();

    }

    public static void testDemo2(){
        Foo foo = (Integer ... ar) -> {

            for (Integer arg : ar) {
                System.out.println(arg);
            }

        };

        foo.sayHello(12, 23, 34, 45, 56);
    }


    public static void testDemo(){


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<List<Integer>> group = group(list, 10);

        System.out.println(" ===>> ");

    }

    public static List<List<Integer>> group(List<Integer> list, Integer pageSize){

        // 页数
        Integer pageNum = list.size() / pageSize;
        if(list.size() % pageSize != 0){
            pageNum = list.size() / pageSize + 1;
        }
        List<List<Integer>> groupList = new ArrayList<>(pageNum);
        for (Integer i = 0; i < pageNum; i++) {
            groupList.add(list.stream().skip(pageSize*i).limit(pageSize).collect(Collectors.toList()));
        }

        return groupList;
    }

}
