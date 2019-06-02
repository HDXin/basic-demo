package top.atstudy.basic.designmode.flyweight.complex;

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
     *
     * 外蕴状态作为参量传入到方法中
     * @param state
     */
    @Override
    public void operation(String state) {
        System.out.println("\nInternal State = " + intrinsicState + " Extrinsic State = " + state);
    }
}
