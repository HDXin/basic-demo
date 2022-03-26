package top.atstudy.basic.designmode.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/9/7 18:26
 * @Desc: 具体观察者
 */
public class Watcher implements Observer {

    public Watcher(Watched w) {
        w.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data has ben changed to : " + ((Watched) o).retrieveData());
    }

}
