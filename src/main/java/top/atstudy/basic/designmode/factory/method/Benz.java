package top.atstudy.basic.designmode.factory.method;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/8 21:34
 *
 * 角色：具体产品
 */
public class Benz implements Car {
    @Override
    public void run() {
        System.out.println(" ===>> Benz run ... ");
    }
}
