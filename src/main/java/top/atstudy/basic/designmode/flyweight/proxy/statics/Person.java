package top.atstudy.basic.designmode.flyweight.proxy.statics;

/**
 * 真实主题角色
 */
public class Person implements IPerson {
    @Override
    public void say() {
        System.out.println(" ==>> hello person ... ");
    }
}
