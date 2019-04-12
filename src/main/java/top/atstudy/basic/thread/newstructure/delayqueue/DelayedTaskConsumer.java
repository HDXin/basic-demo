package top.atstudy.basic.thread.newstructure.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 14:04
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
