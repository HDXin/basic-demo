package top.atstudy.basic.designmode.flyweight.vender;

public class VenderClient {

    private static Order[] flavors = new Flavor[20];
    private static int ordersMade = 0;
    private static FlavorFactory flavorFactory;

    /**
     * 静态方法，提供一杯咖啡
     * @param aFlavor
     */
    public static void takeOrders(String aFlavor){
        flavors[ordersMade++] = flavorFactory.getOrder(aFlavor);
    }

    public static void main(String[] args) {

        //创建风味工厂对象
        flavorFactory = new FlavorFactory();

        //创建一个个咖啡对象
        takeOrders("Black Coffee");
        takeOrders("Capucino");
        takeOrders("Espresso");
        takeOrders("Espresso");
        takeOrders("Capucino");
        takeOrders("Capucino");
        takeOrders("Espresso");
        takeOrders("Black Coffee");
        takeOrders("Espresso");

        //将所创建的咖啡对象卖给客户
        for(int i=0; i< ordersMade; i++){
            flavors[i].serve();
        }

        //打印出卖出的咖啡的总数
        System.out.println("\nTotal teaFlavor objects made: " + flavorFactory.getTotalFlavorsMade());

    }

}
