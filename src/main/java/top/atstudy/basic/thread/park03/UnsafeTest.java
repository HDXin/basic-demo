package top.atstudy.basic.thread.park03;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeTest {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {

//        test03();

        test05();

    }

    private static void test05() throws InterruptedException, NoSuchFieldException {

        ExecutorService service = Executors.newFixedThreadPool(1000);
        //不做任何处理
//        Counter counter = new StupiedCounter();

        //synchronized 锁
//        Counter counter = new SynchronizedCounter();

        //lock 锁
//        Counter counter = new LockCounter();

        //Atomic
        Counter counter = new AtomicCounter();

        //CAS
//        Counter counter = new CasCounter();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter, 10000));
        }

        service.shutdownNow();
        service.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();


        System.out.println("Counter result: " + counter.getCounter());
        System.out.println("Time passed in ms: " + (end - start));
    }


    private static void test03(){
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe.toString());

    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            ((Field) f).setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    interface Counter{
        void increment();

        long getCounter();
    }

    static class StupiedCounter implements  Counter {

        private long counter = 0;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class AtomicCounter implements Counter {

        private AtomicLong counter = new AtomicLong();

        @Override
        public void increment() {
            counter.addAndGet(1);
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class SynchronizedCounter implements Counter{

        private long counter = 0L;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public synchronized long getCounter() {
            return counter;
        }
    }
    static class LockCounter implements Counter {

        private long counter = 0L;

        private Lock lock = new ReentrantLock();

        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }

        }

        @Override
        public long getCounter() {
            try {
                lock.lock();
                return counter;
            } finally {
                lock.unlock();
            }
        }
    }

    static class CasCounter implements Counter {

        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        CasCounter() throws NoSuchFieldException {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
        }

        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)){
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class CounterRunnable implements Runnable {

        private final Counter counter;
        private final int num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }
}
