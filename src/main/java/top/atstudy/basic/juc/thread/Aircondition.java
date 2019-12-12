package top.atstudy.basic.juc.thread;

public class Aircondition {

    private Integer nums = 0;

    public synchronized void increment() throws InterruptedException {

        //1、判断
        while (nums != 0){
            this.wait();
        }

        //2、干活
        nums++;
        System.out.println(Thread.currentThread().getName() + "生成一个, 现有: " + nums);

        //3、通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {

        //1、判断
        while (nums == 0){
            this.wait();
        }

        //2、干活
        nums--;
        System.out.println(Thread.currentThread().getName() + "消费一个, 剩余: " + nums);

        //3、通知
        this.notifyAll();
    }

    public static void main(String[] args) {

        Aircondition condition = new Aircondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    condition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    condition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    condition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    condition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }

}
