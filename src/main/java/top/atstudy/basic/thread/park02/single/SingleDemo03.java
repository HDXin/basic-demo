package top.atstudy.basic.thread.park02.single;

/**
 * 
 */
public class SingleDemo03 {

    private static SingleDemo03 instance = null;

    private SingleDemo03(){}

    private synchronized SingleDemo03 instance(){
        if(null == instance){
            instance = new SingleDemo03();
        }
        return SingleDemo03.instance;
    }


}
