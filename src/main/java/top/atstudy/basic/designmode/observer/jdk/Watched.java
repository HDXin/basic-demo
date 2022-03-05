package top.atstudy.basic.designmode.observer.jdk;

import java.util.Observable;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/9/7 18:24
 * @Desc:
 */
public class Watched extends Observable {

    private String data = "";

    public String retrieveData() {
        return data;
    }

    public void changeData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }

}
