package top.atstudy.basic.thread.park01.threadpriotity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置线程的优先级
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority){
        this.priority = priority;
    }
    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(this.priority);
        while (true){
            for(int i=1; i<10; i++){
                d += (Math.PI + Math.E)/(double)i;
                if(i % 100 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0)
                return ;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<2; i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));

        exec.shutdown();
    }
}
