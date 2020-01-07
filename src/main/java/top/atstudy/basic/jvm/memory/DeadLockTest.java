package top.atstudy.basic.jvm.memory;

import java.util.concurrent.TimeUnit;

public class DeadLockTest {

    public static void main(String[] args) {

        new Thread(() -> {A.method(); }, "AA").start();
        new Thread(() -> {B.method();}, "BB").start();


    }

}

class A {

    public static synchronized void method(){
        System.out.println(" A method ");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            B.method();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

class B {
    public static synchronized void method(){
        System.out.println(" B method ");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            A.method();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}