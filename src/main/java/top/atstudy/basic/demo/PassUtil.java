package top.atstudy.basic.demo;

import java.util.ArrayList;
import java.util.List;

public class PassUtil {

    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            '~', '!', '@', '#', '$', '%',
            '^', '&', '*', '(', ')', '_',
            '+', '=', '-', '`', '[', ']',
            '{', '}', '|', ';', ':', '"',
            ',', '.', '/', '<', '>', '?',
    };

    private static class Count {

        private static List<Integer> indexs = new ArrayList<>();

        static {
            indexs.add(0, 0);
        }


    }


    public static void main(String[] args) {
        System.out.println(chars.length);

        long sum = 615;
        int size = chars.length;
        long length = sum / size + 1;
        long index = sum % size;
        System.out.println("length: " + length + ", index: " + index);

        // 615 - 21 = 594  66 * 9


//        System.out.println(chars.length);
//        long a = 1;
//        long sum = 0;
//        for (int i = 1; i < 11; i++) {
//            a *= chars.length;
//
//            System.out.println(i + "位：" + a);
//
//            sum += a;
//        }
//        ;
//        System.out.println("共：" + sum);

    }


}
