package top.atstudy.basic.thread.park02.single;

/**
 * 可以推荐
 * 不能懒加载
 */
public class SingleDemo01 {

    private static final SingleDemo01 instance = new SingleDemo01();

    private SingleDemo01(){}
    private SingleDemo01 instance(){
        return SingleDemo01.instance;
    }


}
