package top.atstudy.basic.jvm.memory;

public class JavaVmStackSOF {

    private int stackLength = 1;

    public void stackleak(){
        stackLength++;
        stackleak();
    }

    public static void main(String[] args) {
        JavaVmStackSOF oom = new JavaVmStackSOF();

        try {
            oom.stackleak();
        } catch (Throwable e){
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }

}
