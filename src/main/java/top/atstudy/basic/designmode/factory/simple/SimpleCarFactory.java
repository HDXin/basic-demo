package top.atstudy.basic.designmode.factory.simple;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 18:27
 *
 * 工厂角色
 */
public class SimpleCarFactory {
    public static final int TYPE_BENZ = 1;
    public static final int TYPE_BOWN = 2;

    public static Car createCar(int type){
        switch (type){
            case TYPE_BENZ:return new Benz();
            case TYPE_BOWN:return new Bmw();
            default:return new Audi();
        }

    }

    /**
     * 测试简单工厂
     * @param args
     */
    public static void main(String[] args) {

        Car car = SimpleCarFactory.createCar(SimpleCarFactory.TYPE_BENZ);
        car.run();


        Car car2 = SimpleCarFactory.createCar(SimpleCarFactory.TYPE_BOWN);
        car2.run();

    }


}
