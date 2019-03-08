package top.atstudy.basic.designmode.factory.simple;


/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 18:25
 *
 * 具体产品角色
 */
public class Benz implements Car {
    @Override
    public void run() {
        System.out.println(" ===>> benz run ... ");
    }
}
