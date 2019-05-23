package top.atstudy.basic.thread.newstructure.scheduledexecutor;

import java.sql.SQLOutput;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 18:21
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    public synchronized String getThermostat(String value){
        return thermostat;
    }

    public synchronized void setThermostat(String value){
        this.thermostat = value;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delay){
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period){
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning off lights");
            light = false;
        }
    }

}
