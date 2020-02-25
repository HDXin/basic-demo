package top.atstudy.basic.thread.park03.newstructure.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 11:19
 *
 * 注：只要有一个线程执行完，就结束
 */
public class HorseRace {

    static final int FINISH_LIME = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorses, final int pause){
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for(int i=0; i< FINISH_LIME; i++)
                    s.append("=");

                System.out.println(s);
                for(Horse horse:horses){
                    System.out.println(horse.tracks());
                }

                for(Horse horse:horses){
                    if(horse.getStrides() >= FINISH_LIME){
                        System.out.println(horse + "won!");
                        exec.shutdownNow();
                        return ;
                    }
                }
                try{
                    TimeUnit.MILLISECONDS.sleep(pause);
                }catch (InterruptedException e){
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });

        for(int i=0; i<nHorses; i++){
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 37;
        int pause = 200;
        if(args.length > 0){
            int n = new Integer(args[0]);
            nHorses = n>0 ? n:nHorses;
        }
        if(args.length > 1){
            int p = new Integer(args[1]);
            pause = p > -1 ? p:pause;
        }
        new HorseRace(nHorses, pause);
    }
}
