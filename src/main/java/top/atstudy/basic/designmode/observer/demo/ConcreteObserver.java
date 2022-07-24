package top.atstudy.basic.designmode.observer.demo;

public class ConcreteObserver implements Observer {

    private Subject subject;

    private String name;

    public ConcreteObserver(Subject subject, String name) {
        this.name = name;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(this.name + "已接到通知 ... ");
    }
}
