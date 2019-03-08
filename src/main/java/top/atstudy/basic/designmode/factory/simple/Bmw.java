package top.atstudy.basic.designmode.factory.simple;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 18:26
 *
 * 具体产品角色
 */
public class Bmw implements Car {
    @Override
    public void run() {
        System.out.println(" ===>> bown run ... ");
    }
}
