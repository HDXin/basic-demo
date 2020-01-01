package top.atstudy.basic.thread.park01.checkinterrupt;

public class NeedsCleanup {
    private final int id;
    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup(){
        System.out.println("Cleaning up " + id);
    }
}
