package top.atstudy.basic.jvm.bytecode.proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("from real subject");
    }
}
