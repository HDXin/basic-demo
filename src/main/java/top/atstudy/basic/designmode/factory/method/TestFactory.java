package top.atstudy.basic.designmode.factory.method;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 21:41
 */
public class TestFactory {
    public static void main(String[] args) {
        CarFactory carFactory = new BenzCarFactory();
        Car car = carFactory.createCar();
        car.run();

        CarFactory carFactory2 = new BmwCarFactory();
        Car car2 = carFactory2.createCar();
        car2.run();
    }
}
