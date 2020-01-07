package top.atstudy.basic.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(12);
        nums.add(22);
        nums.add(33);
        nums.add(55);

        Stream<Integer> stream = nums.stream();
        //内部遍历
//        stream.forEach(System.out::println);

        List<Integer> temp = stream.sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        temp.forEach(System.out::println);

//        Stream<Integer> s2 = Stream.of(12, 23, 34);

    }

}
