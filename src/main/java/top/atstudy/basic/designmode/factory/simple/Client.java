package top.atstudy.basic.designmode.factory.simple;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/9 13:21
 */
public class Client {
    /**
     * 测试简单工厂
     * @param args
     */
    public static void main(String[] args) {
        Car car = CarFactory.createCar(CarFactory.TYPE_BENZ);
        car.run();

        Car car2 = CarFactory.createCar(CarFactory.TYPE_BOWN);
        car2.run();
    }
}
