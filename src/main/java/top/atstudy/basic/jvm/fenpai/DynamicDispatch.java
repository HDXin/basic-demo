package top.atstudy.basic.jvm.fenpai;

/**
 * 动态分派
 */
public class DynamicDispatch {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("hello man");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("hello woman");
        }
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();

        man.sayHello();
        woman.sayHello();

        man = new Woman();
        man.sayHello();

        int i = 0;
        int a = i++;
        int b = ++i;

    }

    public int test03(){

        int a = 100;
        int b = 200;
        int c = 300;
        return (a+b)*c;
    }

}
