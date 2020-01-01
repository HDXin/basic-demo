package top.atstudy.basic.thread.park01.task;

public class BasicThread {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }

}
