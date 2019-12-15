package top.atstudy.basic.function;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate date = LocalDate.of(2017, 12, 23);
        System.out.println(date);


    }

}
