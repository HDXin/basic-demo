package top.atstudy.basic.proxy.cglib;

public class UserService {

    public Boolean login(String tel, String pwd) {

        System.out.println("tel:" + tel + ", pwd:" + pwd);

        return true;
    }

    public Boolean logout(){
        System.out.println("退出成功 ... ");
        return true;
    }

}
