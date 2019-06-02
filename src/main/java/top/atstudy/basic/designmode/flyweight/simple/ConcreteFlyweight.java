package top.atstudy.basic.designmode.flyweight.simple;

/**
 * 具体享元角色
 */
public class ConcreteFlyweight extends Flyweight {

    private Character intrinsicState = null;

    /**
     * 构造子， 内蕴状态作为参量传入
     * @param intrinsicState
     */
    public ConcreteFlyweight(Character intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    /**
     * 外蕴状态作为参量传入方法中，改变方法的行为
     * 但是并不改变对象的内蕴状态
     * @param state
     */
    @Override
    public void operation(String state) {
        System.out.println("\nIntrinsic State = " + intrinsicState + ", Extrinsic State = " + state);
    }
}
