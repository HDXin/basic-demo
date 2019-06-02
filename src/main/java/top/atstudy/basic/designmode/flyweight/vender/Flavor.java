package top.atstudy.basic.designmode.flyweight.vender;

public class Flavor extends Order {

    private String flavor;

    /**
     * 构造子，内蕴状态以参量方式传入
     * @param flavor
     */
    public Flavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 将咖啡卖给客人
     */
    @Override
    public void serve() {
        System.out.println("Serving Flavor " + flavor);
    }

    /**
     * 返还咖啡名字
     * @return
     */
    @Override
    public String getFlavor() {
        return this.flavor;
    }
}
