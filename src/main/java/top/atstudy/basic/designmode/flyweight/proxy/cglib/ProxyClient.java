package top.atstudy.basic.designmode.flyweight.proxy.cglib;

public class ProxyClient {

    public static void main(String[] args) {

        demo();

    }


    private static void demo(){

        CglibProxy proxy = new CglibProxy();
        UserDaoImpl userDao = (UserDaoImpl) proxy.getInstance(new UserDaoImpl());
        System.out.println(userDao.create(1, 2));
    }
}
