package top.atstudy.basic.jvm.memory;

/**
 * 虚拟机栈和本地方法栈溢出
 *
 * -Xss128k
 *
 */
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
