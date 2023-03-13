package top.atstudy.basic.netty.nio.selector.demo2;

public class MainThread {


    public static void main(String[] args) {

        // 这里不做关于IO和业务的操作

        // 1.创建IO Thread （一个或多个）
        SelectorThreadGroup group = new SelectorThreadGroup(3);

        // 2.应该把监听（7733）的server 注册到某一个 selector 上
        group.bind(7733);


    }

}
