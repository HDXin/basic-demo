package top.atstudy.basic.juc.function;

public class Client {

    /**
     * 拷贝小括号、写死右箭头、落地大括号
     * @param args
     */
    public static void main(String[] args) {

        Foo foo = (Integer ... ar) -> {

            for (Integer arg : ar) {
                System.out.println(arg);
            }

        };

        foo.sayHello(12, 23, 34, 45, 56);

    }

}
