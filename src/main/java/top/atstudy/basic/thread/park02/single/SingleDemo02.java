package top.atstudy.basic.thread.park02.single;

/**
 *
 */
public class SingleDemo02 {

    private static SingleDemo02 instance = null;

    private SingleDemo02(){}

    private SingleDemo02 instance(){
        if(null == instance){
            instance = new SingleDemo02();
        }
        return SingleDemo02.instance;
    }


}
