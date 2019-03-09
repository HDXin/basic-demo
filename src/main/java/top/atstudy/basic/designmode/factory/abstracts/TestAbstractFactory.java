package top.atstudy.basic.designmode.factory.abstracts;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/9 10:24
 */
public class TestAbstractFactory {

    public static void main(String[] args) {
       Car car = new BenzFactory().createCar();
       car.run();

       Car car2 = new BmwFactory().createCar();
       car2.run();

    }

}
