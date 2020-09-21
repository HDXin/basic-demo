package top.atstudy.basic.reference;

import java.io.IOException;
import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {


    public static void main(String[] args) throws IOException {

        //强引用
//        demo();

        //软引用
//        demo2();

        //弱引用
//        demo3();

        //虚引用
//        demo4();

        //ThreadLocal
        demo5();


    }

    private static volatile ThreadLocal<MM> threadLocal = new ThreadLocal<>();

    private static void demo5(){

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new MM());
        }).start();

    }

    /**
     * 引用：虚引用
     * 应用：堆外内存回收
     */
    private static void demo4(){
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<byte[]> phantomReference = new PhantomReference<>(new byte[1024*1024*12], queue);
        final List<Byte[]> list = new ArrayList<>();

        new Thread(() -> {
            while (true){
                list.add(new Byte[1024*1024]);
            }

        }).start();

        new Thread(() -> {
            while (true){
                Reference b = queue.poll();
                if(b != null){
                    System.out.println("内存已被回收 ... ");
                }
            }
        }).start();


    }

    /**
     * 引用：弱引用
     * 应用：只要GC必清理
     */
    private static void demo3(){
        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024*1024*12]);
        System.out.println(weakReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(weakReference.get());

        byte[] b = new byte[1024*1024*10];
        System.out.println(weakReference.get());
    }

    /**
     * 引用：软引用
     * 应用：缓存，内存不够的时候清理
     */
    private static void demo2(){

        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*12]);
        System.out.println(softReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReference.get());

        byte[] b = new byte[1024*1024*10];
        System.out.println(softReference.get());

    }

    /**
     * 引用：强引用
     * @throws IOException
     */
    private static void demo() throws IOException {

        MM m = new MM();
        m = null;
        System.gc();

        System.in.read();
    }

    private static class MM{
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

}
