package top.atstudy.basic.thread.xiezuo.productconsumer;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/11 10:59
 */
public class Meal {

    private final int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}
