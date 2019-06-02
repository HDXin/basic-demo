package top.atstudy.basic.designmode.flyweight.complex;

public class CompositeFlyweightClient {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fly = factory.factory("aba");
        fly.operation("Composite Call");

        factory.checkFlyweight();
    }

}
