package top.atstudy.basic.designmode.observer.demo;

public class Client {

    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();

        Observer o = new ConcreteObserver("张飞");
        subject.attach(o);

        Observer o2 = new ConcreteObserver("关羽");
        subject.attach(o2);


        subject.notifyObserver();

    }

}
