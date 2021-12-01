package top.atstudy.basic.designmode.observer.demo;

public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this.name + "已接到通知 ... ");
    }
}
