package top.atstudy.basic.designmode.flyweight.complex;

/**
 * 抽象享元角色
 */
public abstract class Flyweight {

    /**
     * 外蕴状态作为参量传入到方法中
     * @param state
     */
    public abstract void operation(String state);
}
