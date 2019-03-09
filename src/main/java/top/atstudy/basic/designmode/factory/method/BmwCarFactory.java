package top.atstudy.basic.designmode.factory.method;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 21:36
 *
 * 角色：具体工厂
 */
public class BmwCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Bmw();
    }
}
