package top.atstudy.basic.thread.park01.group;

public class ThreadGroupTest {

    public static void main(String[] args) {

//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

        create();

    }

    private static void create(){

        ThreadGroup tg01 = new ThreadGroup("TG01");
        Thread t = new Thread(tg01, () -> {
            System.out.println("t " + Thread.currentThread().getName());
            System.out.println("t " + Thread.currentThread().getThreadGroup().getName());
        }, "T01");
        t.start();

        Thread t2 = new Thread(tg01, () -> {
            System.out.println("t2 " + Thread.currentThread().getName());
            System.out.println("t2 " + Thread.currentThread().getThreadGroup().getName());
        }, "T02");
        tg01.setDaemon(true);
        t2.start();

        System.out.println(tg01.activeCount());
        System.out.println(tg01.activeGroupCount());

    }


}
