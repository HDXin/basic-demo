package top.atstudy.basic.designmode.flyweight.proxy.statics;

public class ProxyClient {

    public static void main(String[] args) {

        IPerson person = new Person();
        IPerson proxy = new PersonProxy(person);
        proxy.say();

    }

}
