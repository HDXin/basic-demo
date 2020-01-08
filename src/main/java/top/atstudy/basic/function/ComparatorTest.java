package top.atstudy.basic.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    private static List<Student> students = null;
    static {
        students = Arrays.asList(
                new Student("Jerry", 25, "13989897800", "789@qq.com"),
                new Student("Jerry", 26, "13989897800", "789@qq.com"),
                new Student("Jerry", 29, "13989897800", "789@qq.com"),
                new Student("Tom", 25, "139898935159", "123@qq.com"),
                new Student("John", 22, "13989892587", "456@qq.com"),
                new Student("John", 36, "13989892587", "456@qq.com"),
                new Student("King", 21, "13989897845", "147@qq.com"),
                new Student("Ben", 29, "13989891212", "896@qq.com"),
                new Student("Ben", 23, "13989891212", "896@qq.com"),
                new Student("MK", 30, "13989895689", "369@qq.com")
        );
    }


    public static void main(String[] args) {

        //排序
        compTest();

    }

    private static void compTest(){

        List<String> list = Arrays.asList("hello", "hiahia", "java", "C#", "C++");

        //字典排序
        print("字段排序");
        list.stream().sorted(String::compareTo).forEach(System.out::println);


        //长度排序
        print("长度排序");
        Comparator<String> comparator = String::compareTo;
        comparator.thenComparing((e1, e2) -> e1.length() - e2.length());
        list.stream().sorted(comparator).forEach(System.out::println);

        //先年龄排序 -> 姓名字典排序
        print("先年龄 -> 再姓名");
        Comparator<Student> comp1 = (e1, e2) -> e1.getAge() - e2.getAge();
        comp1.thenComparing((e1, e2) -> e1.getName().compareTo(e2.getName()));
        students.stream().sorted(comp1).forEach(System.out::println);


    }


    private static void print(String str){
        if(str != null && str.trim() != ""){
            System.out.println(String.format("========= %s ===========", str));
        } else {
            System.out.println("=======================");
        }
    }

}
