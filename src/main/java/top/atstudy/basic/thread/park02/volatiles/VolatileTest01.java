package top.atstudy.basic.thread.park02.volatiles;

import java.util.concurrent.TimeUnit;

public class VolatileTest01 {

    private static volatile int INI_VALUE = 0;

    private static final int MAX_LIMIT = 5;

    public static void main(String[] args) {

        new Thread(() -> {
            int localValue = INI_VALUE;
            while (localValue < MAX_LIMIT){
                if(localValue != INI_VALUE){
                    System.out.printf("The value updated to [%d]\n", INI_VALUE);
                    localValue = INI_VALUE;
                }
            }


        }, "READER").start();

        new Thread(() -> {
            int localValue = INI_VALUE;
            while (INI_VALUE < MAX_LIMIT){
                System.out.printf("updated the value to [%d]\n", ++localValue);
                INI_VALUE = localValue;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, " ==>> UPDATED").start();



    }

}
