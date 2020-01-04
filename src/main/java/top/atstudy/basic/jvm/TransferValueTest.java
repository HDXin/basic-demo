package top.atstudy.basic.jvm;

public class TransferValueTest {

    public void changeValue(int age){
        age = 30;
    }

    public void changeValue2(Person p){
        p.setName("Jerry");
    }

    public void changeValue3(String str){
        str = "hello ... ";
    }

    public static void main(String[] args) {

        TransferValueTest test = new TransferValueTest();
        int age = 200;
        test.changeValue(age);
        System.out.println(" ===>> age: " + age);

        Person p = new Person();
        p.setName("John");
        test.changeValue2(p);
        System.out.println(" ===>> name: " + p.getName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println(" ===>> str: " + str);

    }

    static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
