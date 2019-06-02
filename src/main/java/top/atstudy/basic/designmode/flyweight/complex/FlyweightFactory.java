package top.atstudy.basic.designmode.flyweight.complex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 享元工厂角色
 */
public class FlyweightFactory {

    private HashMap flies = new HashMap();

    /**
     * 默认构造子
     */
    public FlyweightFactory() {
    }

    /**
     * 复合享元工厂方法，所需状态以参量形式传入
     * 这个参量恰好可以使用String
     * 类型：读者完全可以使用一个聚集，如：Vector 对象等
     * @param compositeState
     * @return
     */
    public Flyweight factory(String compositeState){
        ConcreteCompositeFlyweight compositeFlyweight = new ConcreteCompositeFlyweight();
        int lenght = compositeState.length();
        Character state = null;
        for(int i=0; i<lenght; i++){
            state = new Character(compositeState.charAt(i));
            System.out.println("factory(" + state + ")");
            compositeFlyweight.add(state, this.factory(state));
        }

        return compositeFlyweight;
    }

    /**
     * 单纯享元工厂方法，所需状态以参量形式传入
     * @param state
     * @return
     */
    public Flyweight factory(Character state){
        //检查具有此状态的享元是否已经存在
        if(flies.containsKey(state)){
            //具有此状态的享元已经存在，因此直接将它返还
            return (Flyweight)flies.get(state);
        }else{
            //具有此状态的享元不存在，因此创建新实例
            Flyweight fly = new ConcreteFlyweight(state);
            //将实例存储到聚集中
            flies.put(state, fly);
            //将实例返还
            return fly;
        }
    }
    public void checkFlyweight(){
        int i=0;
        System.out.println("\n============================ checkFlyweight() ==========================");
        for(Iterator it = flies.entrySet().iterator(); it.hasNext(); ){
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("Item " + (++i) + ":" + e.getKey());
        }
        System.out.println("\n============================ checkFlyweight() ==========================");
    }
}
