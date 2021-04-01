package top.atstudy.basic.designmode.flyweight.proxy.statics;

/**
 * 代理主题角色
 */
public class PersonProxy implements IPerson {

    private IPerson person;

    public PersonProxy(IPerson person) {
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println(" ===>> before say ... ");
        person.say();
        System.out.println(" ===>> end say ... ");
    }
}
