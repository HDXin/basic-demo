package top.atstudy.basic.juc.function;

public class Client {

    public static void main(String[] args) {

        Foo foo = () -> {
            System.out.println(" say hello ... ");
        };

        foo.sayHello();

    }

}
