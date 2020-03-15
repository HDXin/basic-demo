package top.atstudy.basic.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
//        demo();

        demo2();


    }

    private static void demo2(){
        Student t = new Student();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    AtomicIntegerFieldUpdater.newUpdater(Student.class, "f").updateAndGet(t, (x) -> x +1);

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ==>> " + t.getF());

    }

    private static void demo(){
        Student t = new Student();
        int a = AtomicIntegerFieldUpdater.newUpdater(Student.class, "f").incrementAndGet(t);
        System.out.println(" a: " + a);

        int a2 = AtomicIntegerFieldUpdater.newUpdater(Student.class, "f2").incrementAndGet(t);
        System.out.println(" a2: " + a2);

//        int a3 = AtomicIntegerFieldUpdater.newUpdater(Student.class, "f3").incrementAndGet(t);
//        System.out.println(" a3: " + a3);

        //parent
//        int pa = AtomicIntegerFieldUpdater.newUpdater(Student.class, "pf").incrementAndGet(t);
//        System.out.println(" pa: " + pa);

//        int pa2 = AtomicIntegerFieldUpdater.newUpdater(Student.class, "pf2").incrementAndGet(t);
//        System.out.println(" pa2: " + pa2);

        int pa3 = AtomicIntegerFieldUpdater.newUpdater(Student.class, "pf3").incrementAndGet(t);
        System.out.println(" pa3: " + pa3);


    }

    private static class Student extends Person {

        public volatile int f;
        protected volatile int f2;
        private volatile int f3;

        public Integer getF() {
            return f;
        }

        public void setF(Integer f) {
            this.f = f;
        }

        public Integer getF2() {
            return f2;
        }

        public void setF2(Integer f2) {
            this.f2 = f2;
        }

        public Integer getF3() {
            return f3;
        }

        public void setF3(Integer f3) {
            this.f3 = f3;
        }
    }

    private static class Person {
        public volatile int pf;
        protected volatile int pf2;
        private volatile int pf3;

        public int getPf() {
            return pf;
        }

        public void setPf(int pf) {
            this.pf = pf;
        }

        public int getPf2() {
            return pf2;
        }

        public void setPf2(int pf2) {
            this.pf2 = pf2;
        }

        public int getPf3() {
            return pf3;
        }

        public void setPf3(int pf3) {
            this.pf3 = pf3;
        }
    }

}
