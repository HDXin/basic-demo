package top.atstudy.basic.designmode.flyweight.proxy.statics;

import top.atstudy.basic.designmode.flyweight.proxy.statics.IPerson;

public class Person implements IPerson {
    @Override
    public void say() {
        System.out.println(" ==>> hello person ... ");
    }
}
