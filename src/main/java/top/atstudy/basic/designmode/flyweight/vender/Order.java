package top.atstudy.basic.designmode.flyweight.vender;

public abstract class Order {

    /**
     * 将咖啡卖客人
     */
    public abstract void serve();

    /**
     * 返还咖啡的名字
     * @return
     */
    public abstract String getFlavor();
}
