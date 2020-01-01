package top.atstudy.basic.thread.park01.threaddaemon;

public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}
