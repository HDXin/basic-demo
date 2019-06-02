package top.atstudy.basic.mianshi;

public class StringTest {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";
        System.out.println("str1 == str2 ? : " + (str1 == str2));

        String str3 = "a" + "bc";
        System.out.println("str1 == str3 ? : " + (str1 == str3));

        String str4 = new String("abc");
        System.out.println("str1 == str4 ? : " + (str1 == str4));

        String str5 = str4.intern();
        System.out.println("str1 == str4 ? : " + (str1 == str4));
        System.out.println("str1 == str5 ? : " + (str1 == str5));

        String str6 = "a" + new String("bc");
        System.out.println("str1 == str6 ? : " + (str1 == str6));

        System.out.println("str4 == str6 ? : " + (str4 == str6));




    }

}
