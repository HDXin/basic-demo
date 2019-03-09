package top.atstudy.basic.designmode.factory.abstracts;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/9 10:05
 */
public class BmwFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Car(new BmwBrand(), new Gearbox8At(), new EditionFlagship());
    }
}
