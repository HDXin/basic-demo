package top.atstudy.basic.designmode.flyweight.complex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 复合享元角色
 */
public class ConcreteCompositeFlyweight extends Flyweight {

    private HashMap flies = new HashMap();

    /**
     * 默认构造子
     */
    public ConcreteCompositeFlyweight() {
    }

    /**
     * 增加一个新的单纯享元对象到聚集中
     * @param key
     * @param fly
     */
    public void add(Character key, Flyweight fly){
        flies.put(key, fly);
    }

    /**
     * 外蕴状态作为参量传入到方法中
     * @param extrinsicState
     */
    @Override
    public void operation(String extrinsicState) {
        Flyweight fly = null;
        for(Iterator it = flies.entrySet().iterator(); it.hasNext(); ){
            Map.Entry e = (Map.Entry) it.next();
            fly = (Flyweight)e.getValue();
            fly.operation(extrinsicState);
        }
    }
}
