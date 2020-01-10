package top.atstudy.basic.thread.park03.newstructure.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 13:46
 */
public class DelayedTask implements Runnable, Delayed {

    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int deltaInMilliseconds) {
        this.delta = deltaInMilliseconds;
        this.trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if(trigger < that.trigger) return -1;
        if(trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.print(this + " ");
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delta) + " Task " + id;
    }

    public String summary(){
        return "(" + id + ":" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask{
        private ExecutorService exec;
        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            this.exec = e;
        }

        @Override
        public void run() {
            for(DelayedTask pt:sequence){
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
