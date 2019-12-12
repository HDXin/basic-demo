package top.atstudy.basic.function;

import java.util.function.Function;

public class FunctionTest {


    public static void main(String[] args) {

        Function<String, String> function = str -> str;
        System.out.println(function.apply("hello function ... "));

        Function<Integer, Integer> name = e -> e*2;
        Function<Integer, Integer> square = e -> e*e;

        System.out.println(name.compose(square).apply(3));
    }

}
