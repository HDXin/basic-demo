package top.atstudy.basic.thread.atomic;

import top.atstudy.basic.thread.gongxiang.EvenChecker;
import top.atstudy.basic.thread.gongxiang.IntGenerator;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
