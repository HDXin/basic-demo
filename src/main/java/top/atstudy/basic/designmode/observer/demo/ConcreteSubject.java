package top.atstudy.basic.designmode.observer.demo;

import java.util.Vector;

public class ConcreteSubject implements Subject {

    private Vector<Observer> observers = new Vector<>();

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        this.observers.forEach( Observer::update);
    }
}
