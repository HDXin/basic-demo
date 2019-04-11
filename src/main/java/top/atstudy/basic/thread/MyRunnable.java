package top.atstudy.basic.thread;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/1 15:43
 */
public class MyRunnable implements Runnable {

    private Integer ticket = 50;

    @Override
    public void run() {

        while (ticket > 0){
            synchronized (Object.class){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + " ... " + ticket);
                    try {
                        Thread.sleep(200);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }
        }

    }

    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        for(int i=0; i<5; i++)
            new Thread(r).start();



    }
}
