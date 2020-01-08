package top.atstudy.basic.thread.park02.single;

/**
 * 推荐写法
 */
public class SingleDemo07 {

    private SingleDemo07(){}

    private enum Singleton {
        INSTANCE;

        private final SingleDemo07 instance;
        Singleton(){
            instance = new SingleDemo07();
        }

        public SingleDemo07 getInstance(){
            return this.instance;
        }

    }

    public static SingleDemo07 instance(){
        return Singleton.INSTANCE.getInstance();
    }
}
