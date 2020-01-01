package top.atstudy.basic.thread.park01.callable;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/1 17:13
 *
 * 带有返回值的任务
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0; i<10; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> fs:results){
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return ;
            }catch (ExecutionException e2){
                System.out.println(e2);
                return ;
            }finally{
                exec.shutdown();
            }
        }
    }

}
