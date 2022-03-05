//package top.atstudy.basic.designmode.observer;
//
//import top.atstudy.basic.designmode.observer.demo.ConcreteObserver;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author: dexin.huang or harley
// * @Email: dexin.huang@paat.com
// * @Date: 2020/12/10 21:44
// * @Desc:
// */
//public class Client {
//
//    static private ConcreteObservable concreteObservable;
//
//    static private ConcreteObserver concreteObserver;
//
//    public static void main(String[] args) {
//
//        // 具体观察者
//        concreteObserver = new ConcreteObserver();
//
//        // 具体背观察者
////        concreteObservable = new ConcreteObservable(concreteObserver);
//
//
//    }
//
//    public void testSleep(Long tenantId, TimeUnit unit, Long time) {
//
//        try {
//            TimeUnit.SECONDS.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//}
