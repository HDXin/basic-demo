package top.atstudy.basic.thread.park01.checkinterrupt;

import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
//        if(args.length != 1){
//            System.out.println("usage: java interruptingIdiom delay-in-mS");
//            System.exit(0);
//        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
        t.interrupt();
    }
}
