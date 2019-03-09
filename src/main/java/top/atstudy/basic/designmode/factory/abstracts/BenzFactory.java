package top.atstudy.basic.designmode.factory.abstracts;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/9 10:04
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Car(new BenzBrand(), new Gearbox6At(), new EditionDeluxe());
    }
}
