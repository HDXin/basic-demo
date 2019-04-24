package top.atstudy.basic.thread.threaddaemon;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {
    @Override
    public void run() {
        try{
            while (true){
                System.out.println("Starting ADaemon");
                TimeUnit.MILLISECONDS.sleep(10);
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }finally {
            System.out.println("This should always run?");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
    }
}
