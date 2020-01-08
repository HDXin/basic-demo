package top.atstudy.basic.thread.park02.single;

/**
 * 推荐写法
 */
public class SingleDemo05 {

    private static volatile SingleDemo05 instance = null;

    private SingleDemo05(){}

    private synchronized SingleDemo05 instance(){
        if(null == instance){
            synchronized (SingleDemo05.class){
                if(null == instance){
                    instance = new SingleDemo05();
                }
            }
        }
        return SingleDemo05.instance;
    }


}
