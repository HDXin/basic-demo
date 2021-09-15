package top.atstudy.basic.designmode.observer;

import java.util.Observer;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/12/10 21:44
 * @Desc:
 */
public class Client {

    static private Watched watched;

    static private Observer watcher;

    public static void main(String[] args) {

        // 创建被观察者
        watched = new Watched();

        // 创建观察者，并将被观察者对象登记
        watcher = new Watcher(watched);

        // 给被观察者对象的状态赋值多次
        watched.changeData("1");
        watched.changeData("2");
        watched.changeData("3");
        watched.changeData("4");

    }

}
