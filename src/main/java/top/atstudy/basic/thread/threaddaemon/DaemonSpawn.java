package top.atstudy.basic.thread.threaddaemon;

public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}
