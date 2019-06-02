package top.atstudy.basic.designmode.flyweight.store;

public class StoreClient {

    private static Order[] flavors = new Flavor[100];
    private static int ordersMade = 0;
    private static FlavorFactory flavorFactory = null;

    /**
     * 静态方法，提供一杯咖啡
     * @param aFlavor
     */
    private static void takeOrders(String aFlavor){
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
        takeOrders("Black Coffee");
        takeOrders("Espresso");
        takeOrders("Capucino");
        takeOrders("Expresso");
        takeOrders("Black Coffee");
        //将所创建的咖啡对象卖个客人
        for(int i=0; i<ordersMade; i++){
            flavors[i].serve(new Table(i));
        }

        //打印卖出的咖啡总数
        System.out.println("\nTotal teaFlavor objects made: " + flavorFactory.getTOtalFlavorsMade());


    }

}
