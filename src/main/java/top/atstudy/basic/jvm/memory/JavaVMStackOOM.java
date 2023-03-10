package top.atstudy.basic.jvm.memory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {

        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });

            thread.start();
        }

    }

    public static void main(String[] args) throws InterruptedException {

//        JavaVMStackOOM oom = new JavaVMStackOOM();
//        oom.stackLeakByThread();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {





        }



        TimeUnit.SECONDS.sleep(10000);

    }

}
