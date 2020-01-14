package top.atstudy.basic.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap tab[] 实现
 * LinkedHashMap 继承 HashMap
 *
 * HashSet 用HashMap实现
 * LinkedHashSet 继承至HashSet,用LinkedHashMap实现有序
 */
public class HashMapClient {

    public static void main(String[] args) {

        Map<Student, Student> map = new LinkedHashMap<>(64);

//        for (int i = 0; i < 100; i++) {
//            Student student = new Student("Jerry", "address-" + i);
//            map.put(student, student);
//        }
//
//        for(Map.Entry<Student, Student> entry: map.entrySet()){
//            Student key = entry.getKey();
//            System.out.println(key.getName() + " " + key.getAddress());
//        }

        int size = tableSizeFor(65);
        System.out.println(size);

        //按位与运算(&)
//        test01();

        //按位或运算(|)
//        test02();

        //异或(^)
//        test03();

        //取反(~)
//        test04();

        //无符号右移(>>>)
//        test05();

    }

    static final int tableSizeFor(int var0) {
        int var1 = var0 - 1;
        var1 |= var1 >>> 1;
        var1 |= var1 >>> 2;
        var1 |= var1 >>> 4;
        var1 |= var1 >>> 8;
        var1 |= var1 >>> 16;
        return var1 < 0 ? 1 : (var1 >= 1073741824 ? 1073741824 : var1 + 1);
    }

    private static void test05(){
        System.out.println("============== 无符号右移（>>>） ================");
        int a = 15;
        int b = a>>>2;
        System.out.println("   " + Integer.toBinaryString(a));
        System.out.println(">>>" + Integer.toBinaryString(b));
        System.out.println(b);

        System.out.println(" ---------------");
        int x = -15;
        int y = x>>>2;
        System.out.println("   " + Integer.toBinaryString(x));
        System.out.println(">>>" + Integer.toBinaryString(y));
        System.out.println(y);

    }

    /**
     * 取反(~)运算
     * 如下示例 ~5=-6
     */
    private static void test04(){
        System.out.println("============== 取反（~） ================");
        int a = 5;
        int b = ~a;
        System.out.println(" " + Integer.toBinaryString(a));
        System.out.println("~" + Integer.toBinaryString(b));
        System.out.println(" ---");
        System.out.println(" " + b);

    }

    /**
     * 异或(^)运算
     * 1^1=0, 0^0=0, 1^0=1, 0^1=1
     * 如下示例 5^9=12
     *  0101
     * ^1001
     *  ----
     *  1100
     */
    private static void test03(){
        System.out.println("============== 异或（^） ================");

        int a = 5;
        int b = 9;
        int c = 5^9;
        System.out.println("  " + Integer.toBinaryString(a));
        System.out.println("^" + Integer.toBinaryString(b));
        System.out.println(" ----");
        System.out.println(" " + Integer.toBinaryString(c));
        System.out.println(c);

    }

    /**
     * 按位 | 运算
     * 0|0=0, 1|1=1, 1|0=1, 0|1=0
     * 如下 6|2=2
     *  110
     * |010
     * ----
     *  110
     */
    private static void test02(){
        System.out.println("============== 按位或（|） ================");
        int a = 6;
        int b = 2;
        int c = a | b;
        System.out.println(" " + Integer.toBinaryString(a));
        System.out.println("| " + Integer.toBinaryString(b));
        System.out.println(" ---");
        System.out.println(" " + Integer.toBinaryString(c));
        System.out.println(" " + c);

    }

    /**
     * 按位 & 运算
     * 1&1=1, 1&0=0, 0&1=0, 0&0=0
     * 如下：5&7=5
     *  101
     * &111
     * ----
     *  101
     */
    private static void test01(){
        System.out.println("============== 按位与（&） ================");
        int a = 5;
        int b = 7;
        int c = 5 & 7;

        System.out.println(" " + Integer.toBinaryString(a));
        System.out.println("&" + Integer.toBinaryString(b));
        System.out.println(" ---");
        System.out.println(" " + Integer.toBinaryString(c));
        System.out.println(c);
    }



    static class Student {
        //姓名
        private String name;
        //地址
        private String address;

        public Student(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(address, student.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}
