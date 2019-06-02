package top.atstudy.basic.designmode.flyweight.simple;

public class FlyweightClient {

    public static void main(String[] args) {

        //创建呀一个享元工厂对象
        FlyweightFactory factory = new FlyweightFactory();

        //向享元工厂对象请求一个内蕴状态为 'a’的享元对象
        Flyweight fly = factory.factory(new Character('a'));

        //以参量方式传入一个外蕴状态
        fly.operation("First Call");

        //向享元工厂对象请求一个内蕴状态为 'b' 的享元对象
        fly = factory.factory(new Character('b'));

        //以参量方式传入一个外蕴状态
        fly.operation("Second Call");

        //向享元工厂对象请求一个内蕴状态为 'a' 的享元对象
        fly = factory.factory(new Character('a'));

        //以参量方式传入一个外蕴状态
        fly.operation("Third Call");

        //检查一共有多上享元对象
        factory.checkFlyweight();

    }
}
