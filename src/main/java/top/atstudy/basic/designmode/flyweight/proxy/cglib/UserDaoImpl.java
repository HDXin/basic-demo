package top.atstudy.basic.designmode.flyweight.proxy.cglib;

public class UserDaoImpl {

    public int create(int x, int y){
        System.out.printf(" ===>> create(%s, %s) ... \n",  x, y);
        return x + y;
    }

}
