package top.atstudy.basic.thread.newstructure.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 14:50
 */
public class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
        exchanger = ex;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                holder = exchanger.exchange(holder);
                for(T x:holder){
                    value = x;
                    holder.remove(x);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final value: " + value);
    }
}
