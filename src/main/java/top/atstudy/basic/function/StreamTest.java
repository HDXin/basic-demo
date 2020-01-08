package top.atstudy.basic.function;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

//        streamTest02();

        //并发流
//        streamTest03();

        //扁平化处理
//        streamTest04();

        //映射处理
//        streamTest05();

        streamTest06();

    }


    private static void streamTest06(){

        //年龄最小
        Optional<Student> optional = students.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getAge)));
        Student student = optional.orElseThrow(() -> new RuntimeException("没有最小值"));
        System.out.println(student);
    }

    /**
     *
     */
    private static void streamTest05(){

        Map<String, Integer> map = students.stream().collect(Collectors.toMap(Student::getName, Student::getAge));
        System.out.println(map);
        print();

        Map<String, Student> itemMap = students.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        System.out.println(itemMap);
        print();

        Map<String, List<Student>> group = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(group);
        print();

    }

    /**
     * 扁平化处理
     */
    private static void streamTest04(){

        List<String> list1 = Arrays.asList("Hi", "hello", "你好");
        List<String> list2 = Arrays.asList("Jerry", "john", "Ben");

        list1.stream().flatMap(item -> list2.stream()
                .map(item2 -> item + " " + item2))
                .forEach(System.out::println);


    }



    /**
     * 并发流，
     */
    private static void streamTest03(){

        List<String> list = new ArrayList<>(2000000);
        for (int i = 0; i < 10000000; i++) {
            list.add(UUID.randomUUID().toString());

            if(i%1000000 == 0){
                System.out.println(i);
            }
        }
        System.out.println(" +++>> 开始排序 ... ");

        long start = System.currentTimeMillis();
        list.parallelStream().sorted();
        long end = System.currentTimeMillis();

        System.out.println(" ===>> " + (end - start));


    }

    private static void streamTest02(){

        List<Student> list = Arrays.asList(
                new Student("Jerry", 25, "13989897800", "789@qq.com"),
                new Student("Tom", 27, "139898935159", "123@qq.com"),
                new Student("John", 22, "13989892587", "456@qq.com"),
                new Student("King", 21, "13989897845", "147@qq.com"),
                new Student("Ben", 33, "13989891212", "896@qq.com"),
                new Student("MK", 30, "13989895689", "369@qq.com")
                );
//        list.stream().forEach(System.out::println);
        print();

        //过滤
        list.stream().filter((e) -> {
            System.out.println("==>> " +e.toString());
            return e.getAge() > 26;
        }).forEach(System.out::println);
        print();

        //name 集合
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        Set<String> set = list.stream().map(Student::getName).collect(Collectors.toSet());
        print();

        //分组
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);
        print();

        //list -> map
        List<Student> lis = list.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }

    private static void streamTest(){
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

    private static void print(){
        System.out.println(" =================================");
    }

    private static List<Student> students = null;
    static {
        students = Arrays.asList(
                        new Student("Jerry", 25, "13989897800", "789@qq.com"),
                        new Student("Tom", 27, "139898935159", "123@qq.com"),
                        new Student("John", 22, "13989892587", "456@qq.com"),
                        new Student("King", 21, "13989897845", "147@qq.com"),
                        new Student("Ben", 33, "13989891212", "896@qq.com"),
                        new Student("MK", 30, "13989895689", "369@qq.com")
                );
    }

    static class Person{
        private String name;
    }

}

class Student {

    private String name;
    private Integer age;
    private String phone;
    private String email;

    public Student(String name, Integer age, String phone, String email) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
