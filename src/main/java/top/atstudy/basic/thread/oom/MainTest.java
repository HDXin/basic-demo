package top.atstudy.basic.thread.oom;

import java.util.concurrent.TimeUnit;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/16 12:59
 * @Description
 */
public class MainTest {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            System.out.println(" ===>> t: " + i);
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

        }


    }

}