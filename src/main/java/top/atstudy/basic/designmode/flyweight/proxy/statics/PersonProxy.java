package top.atstudy.basic.designmode.flyweight.proxy.statics;

import top.atstudy.basic.designmode.flyweight.proxy.statics.IPerson;

public class PersonProxy implements IPerson {

    private IPerson person;
    public PersonProxy(IPerson person) {
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println(" ===>> before say ... ");
        person.say();
    }
}
