package top.atstudy.basic.thread.park01.task;

/**
 *
 * 通过实现 Runnable 接口定义一个任务
 */
public class LiftOff implements Runnable{
    protected int countDown = 5;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown:"LiftOff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
