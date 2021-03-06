package top.atstudy.basic.thread.park01.threadexception;

public class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());

        throw new RuntimeException("运行时异常");
    }
}
