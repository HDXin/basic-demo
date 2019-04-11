package top.atstudy.basic.thread.xiezuo.dana;

import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/10 17:50
 */
public class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car car){
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On! ");
                TimeUnit.MICROSECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (Exception e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println(" Ending Wax On task");
    }
}
