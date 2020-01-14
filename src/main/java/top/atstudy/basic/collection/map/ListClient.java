package top.atstudy.basic.collection.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListClient {

    private static final Integer num = new Random().nextInt(47);

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(1);
        for (int i = 0; i < 100; i++) {
            list.add(0, i);
        }


    }


}
