package top.atstudy.basic.jvm.bytecode;

public class MyByteCodeTest02 {

    String str = "welcome";

    private int x = 5;

    private static Integer in = 10;

    public static void main(String[] args) {
        MyByteCodeTest02 test02 = new MyByteCodeTest02();

        test02.setX(8);

        in = 20;
    }

    public int getX() {
        return x;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str){
        synchronized (Object.class){
            System.out.println("hello world");
        }
    }
    private synchronized static void test02(){
        System.out.println("hello static synchronized");
    }
}
