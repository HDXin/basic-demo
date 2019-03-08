package top.atstudy.basic.thread;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/2/28 23:16
 */
public class MyThread extends Thread {

    private static Integer ticket = 30;

    @Override
    public void run() {
        while(ticket > 0){
            synchronized (Object.class){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + " ... " + ticket);
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }
        }
    }

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();
    }

}
