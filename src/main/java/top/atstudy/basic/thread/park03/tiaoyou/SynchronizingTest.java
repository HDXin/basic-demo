package top.atstudy.basic.thread.park03.tiaoyou;

public class SynchronizingTest extends Incrementable {
    @Override
    public synchronized void increment() {
            ++counter;
    }
}
