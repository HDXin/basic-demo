package top.atstudy.basic.neibulei;


/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/13 22:57
 */
public interface Person {

    void run();

    class Student implements Person{
        @Override
        public void run() {
            System.out.println("student run ... ");
        }
    }

}
