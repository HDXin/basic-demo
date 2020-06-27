package top.atstudy.basic.juc.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        demo();

        // 拒绝策略
//        demo2();

        //线程池异步处理
        demo3();

    }

    private static void demo3() throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,
                100,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());


        SkuService skuService = new SkuService();
        long start = System.currentTimeMillis();
        Map<Integer, FutureTask<Boolean>> taskMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            FutureTask<Boolean> task = new FutureTask(new SkuExecutor(i, skuService));
            executor.submit(task);

            taskMap.put(i, task);
        }

        taskMap.forEach((k, v) -> {
            try {
                System.out.println(" ===>> key:" + k + " , v:" + v.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();

        System.out.println(" ==>> times: " + (end - start));

        //关闭线程池
        executor.shutdown();
    }


    private static void demo2(){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,
                4,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 15; i++) {
            executor.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(" ===>> " + Thread.currentThread().getName());

            });
        }



    }


    private static void demo(){

        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            System.out.println("hiahia");
        };
        executorService.submit(runnable);

    }


    /**
     * 扣减库存
     */
    private static class SkuExecutor implements Callable<Boolean> {

        private Integer size;

        private SkuService skuService;

        public SkuExecutor(Integer size, SkuService skuService) {
            this.size = size;
            this.skuService = skuService;
        }

        @Override
        public Boolean call() throws Exception {
            TimeUnit.MILLISECONDS.sleep(1000);
            this.skuService.sub(this.size);
            return this.size % 2 == 0;
        }
    }

    private static class SkuService {

        public void sub(Integer size){
            System.out.println(" ==>> " + Thread.currentThread().getName() + "  扣减库存 ... " + size);
        }


    }



}
