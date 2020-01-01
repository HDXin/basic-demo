package top.atstudy.basic.thread.park01.task;

public class MoreBaiscThreads {

    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }

}
