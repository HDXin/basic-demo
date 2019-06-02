package top.atstudy.basic.designmode.flyweight.vender;

public class FlavorFactory {

    private Order[] flavors = new Flavor[10];
    private int ordersMade = 0;
    private int totalFlavors = 0;

    /**
     * 工厂方法，根据所需的风味提供咖啡
     * @param flavorToGet
     * @return
     */
    public Order getOrder(String flavorToGet){
        if(ordersMade > 0){
            for(int i=0; i< ordersMade; i++){
                if(flavorToGet.equals(flavors[i].getFlavor()))
                    return flavors[i];
            }
        }

        flavors[ordersMade] = new Flavor(flavorToGet);
        totalFlavors++;
        return flavors[ordersMade++];
    }

    /**
     * 辅助方法，返还创建过的风味对象的个数
     * @return
     */
    public int getTotalFlavorsMade(){
        return totalFlavors;
    }

}
