package top.atstudy.basic.designmode.flyweight.proxy.jdk;

public class ProxyClient {

    public static void main(String[] args) {

        // jdk 代理
        demo();

    }


    private static void demo(){

        Math proxy = (Math) new JdkProxy().getInstance(new MathImpl());
        System.out.println(proxy.add(1, 2));
        System.out.println(proxy.sub(1, 2));

    }
}
