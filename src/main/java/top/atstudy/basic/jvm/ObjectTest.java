package top.atstudy.basic.jvm;

public class ObjectTest {

    private int aa;

    public static void main(String[] args) {

        ObjectTest test = new ObjectTest();
        test.test03();

        Object obj = new Object();
        obj.hashCode();

    }

    private void test03(){



    }

    private void test02(){
        ObjectTest obj = new ObjectTest();
        System.out.println(obj.aa);
    }

    private void test01(){
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
