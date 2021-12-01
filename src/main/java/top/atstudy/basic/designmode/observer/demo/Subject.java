package top.atstudy.basic.designmode.observer.demo;

public interface Subject {

    /**
     * 调用这个方法登记一个观察者
     *
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 调用这个方法删除一个观察者
     *
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 调用这个方法通知所有的登记过的观察者
     */
    void notifyObserver();

}
