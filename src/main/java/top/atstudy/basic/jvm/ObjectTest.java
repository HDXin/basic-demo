package top.atstudy.basic.jvm;

public class ObjectTest {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");

        System.out.println("str1 == str2 ? : " + (str1 == str2));
        System.out.println("str1.equals(str2) ? : " + str1.equals(str2));


        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
