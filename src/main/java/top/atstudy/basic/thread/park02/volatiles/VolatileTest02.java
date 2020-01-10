package top.atstudy.basic.thread.park02.volatiles;

import java.util.concurrent.TimeUnit;

public class VolatileTest02 {

    private static int INI_VALUE = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    INI_VALUE++;
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println(INI_VALUE);
    }

}
