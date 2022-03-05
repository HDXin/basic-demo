package top.atstudy.basic.thread;

import cn.hutool.crypto.SecureUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MD5Demo {

    private static final String md = "AB56B4D92B40713ACC5AF89985D4B786";


    public static void main(String[] args) throws IOException {

                traversal(5);
//        print();

    }

    private static void print(){
        String str = "6846860684F05029ABCCC09A53CD66F1";
        String md5 = SecureUtil.md5("abcde").toUpperCase();
        System.out.println("md5: " + md5);
        System.out.println(md5.equals(str));
    }


    private static final char[] arr = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            '!', '?', '_', '@', '#', '$',
            '^', '&', '*', '(', ')', '.',
            ',', ';', '.', '=', '+', '\"',
            '\'', ':', '<', '>', '/', '\\',
            '[', ']', '{', '}', '|'
    };

    public static void decipher() throws IOException {

        for (int i = 4; i < 20; i++) {
            traversal(i);
        }

    }

    public static void traversal(int size) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ints.add(arr.length - 1);
        }
//        System.out.println(ints);

        while (isComplate(ints)) {
            if(ints.stream().allMatch(e -> e == 0)){
                System.out.println(buildStr(ints));
            }

            next(ints);
            String pass = buildStr(ints);
//            System.out.println(pass);
            if (md.equals(SecureUtil.md5(pass).toUpperCase())) {
                System.out.println(pass);
            }
        }

    }

    private static String buildStr(List<Integer> ints) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.size(); i++) {
            sb.append(String.valueOf(arr[ints.get(i)]));
        }
        return sb.toString();
    }

    private static void next(List<Integer> ints) {

        for (int i = ints.size() - 1; i >= 0; i--) {
            Integer temp = ints.get(i) - 1;
            if (temp >= 0) {
                ints.set(i, temp);
                return;
            }
            temp = arr.length - 1;
            ints.set(i, temp);
        }

    }

    public static Boolean isComplate(List<Integer> ints) {
        return ints.stream().anyMatch(e -> e != 0);
    }


}
