package top.atstudy.basic.thread.park02.single;

/**
 * 推荐写法
 */
public class SingleDemo06 {

    private SingleDemo06(){}

    private SingleDemo06 instance(){
        return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        private static final SingleDemo06 instance = new SingleDemo06();
    }


}
