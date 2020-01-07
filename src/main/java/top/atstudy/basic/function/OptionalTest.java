package top.atstudy.basic.function;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalTest {

    public static void main(String[] args) throws IOException {

        Optional<Integer> optional = Optional.of(123);

        System.out.println(optional.isPresent());

        Integer i = OptionalInt.empty().orElseThrow(() -> new IOException());


    }

}
