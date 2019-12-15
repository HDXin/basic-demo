package top.atstudy.basic.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(12);
        nums.add(22);
        nums.add(33);
        nums.add(55);

        Stream<Integer> stream = nums.stream();


        Stream<Integer> s2 = Stream.of(12, 23, 34);

    }

}
