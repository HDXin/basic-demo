package top.atstudy.basic.proxy;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/10/13 11:27
 * @Desc: xxx
 */
public class DemoProxyClient {

    public static void main(String[] args) {

        MyInvocationHandler invocation = new MyInvocationHandler();
        Auth auth = new AuthImpl();
        Auth proxy = (Auth) invocation.bind(auth);
        System.out.println(proxy.add(1, 2));

    }

}
