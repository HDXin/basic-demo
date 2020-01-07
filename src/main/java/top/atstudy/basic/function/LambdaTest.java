package top.atstudy.basic.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaTest {

    public static void main(String[] args) {

        //接收一个对象，返回一个对象
//        functionTest();

        //接收一个对象，不返回值
        consumerTest();

        //接收一个对象，返回一个布尔值
//        predicateTest();

        //不接受任何对象，返回一个对象
//        supplierTest();
    }

    /**
     * @param: 接收一个对象
     * @return 返回一个对象
     */
    public static void functionTest() {
        Function<Integer, String> function = (Integer i) -> "hiahia:" + i;
        String str = function.apply(5);
        System.out.println(str);
    }

    /**
     * @param: 接收一个对象，处理该对象
     * @return: null 不返回
     */
    public static void consumerTest(){
        List<String> list = Arrays.asList("abc", "123", "xyz", "wc", "abc", "bce");
        list.forEach((e) -> System.out.println(e));
        System.out.println("===");
        list.forEach(System.out::println);

        System.out.println(" === ");
        list.stream().filter(e -> e.equals("abc")).filter(e -> e.equals("abc")).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println(" === ");
        list.forEach(System.out::println);

        System.out.println(" === ");
        list.stream().sorted(String::compareTo).forEach(System.out::println);


    }

    /**
     * @param: 接收一个对象
     * @return: 返回布尔值
     */
    public static void predicateTest(){

        Predicate<String> predicate = (str) -> {
            System.out.println("hishis: " + str);
            return true;
        };
        System.out.println(predicate);
    }

    /**
     * @param: null
     * @return: 返回一个对象
     */
    public static void supplierTest(){

        Supplier<String> str = () -> "hiahia";

        System.out.println(str.get());

    }

}
