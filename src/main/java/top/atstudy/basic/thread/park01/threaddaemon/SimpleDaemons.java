package top.atstudy.basic.thread.park01.threaddaemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                System.out.println(Thread.currentThread() + " " + this);
                TimeUnit.MILLISECONDS.sleep(60);
            }
        }catch (InterruptedException e){
            System.out.print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<5; i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(200);
    }
}
