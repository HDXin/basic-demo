package top.atstudy.basic.designmode.observer.demo;

public class Client {

    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();

        Observer o = new ConcreteObserver(subject,"张飞");
        subject.attach(o);

        Observer o2 = new ConcreteObserver(subject, "关羽");

        subject.notifyObserver();


        // rxjava2、reactor、webflux
    }

}
