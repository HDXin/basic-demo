package top.atstudy.basic.thread.park02.single;

/**
 * 
 */
public class SingleDemo04 {

    private static SingleDemo04 instance = null;

    private SingleDemo04(){}

    private synchronized SingleDemo04 instance(){
        if(null == instance){
            synchronized (SingleDemo04.class){
                if(null == instance){
                    instance = new SingleDemo04();
                }
            }
        }
        return SingleDemo04.instance;
    }


}
