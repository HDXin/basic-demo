package top.atstudy.basic.thread.park03.newstructure.exchanger;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 14:55
 */
public class ExchangerDemo {

    static int size = 10;
    static int delay = 5;
    public static void main(String[] args) throws InterruptedException {
        if(args.length > 0){
            size = new Integer(args[0]);
        }

        if(args.length > 1){
            delay = new Integer(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat> productList = new CopyOnWriteArrayList<>();
        List<Fat> consumerList = new CopyOnWriteArrayList<>();

        exec.execute(new ExchangerProducer<Fat>(xc, BasicGenerator.create(Fat.class), productList));
        exec.execute(new ExchangerConsumer<Fat>(xc, consumerList));

        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();

    }

}
