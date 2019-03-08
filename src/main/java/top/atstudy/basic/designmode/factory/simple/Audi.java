package top.atstudy.basic.designmode.factory.simple;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 18:29
 *
 * 具体产品角色
 */
public class Audi implements Car {
    @Override
    public void run() {
        System.out.println(" ===>> audi run ... ");
    }
}
