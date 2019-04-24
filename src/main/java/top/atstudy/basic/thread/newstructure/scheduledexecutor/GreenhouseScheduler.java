package top.atstudy.basic.thread.newstructure.scheduledexecutor;

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
        return ;
    }

}
