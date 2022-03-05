package top.atstudy.basic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        Auth tempProxy = (Auth) invocation.bind(auth);
        final Auth temp = tempProxy;

        tempProxy = (Auth) Proxy.newProxyInstance(tempProxy.getClass().getClassLoader(), new Class[]{Auth.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("abc before ... ");
                Object result = method.invoke(temp, args);
                System.out.println("abc after ... ");

                return result;
            }
        });

        final Auth temp2 = tempProxy;
        tempProxy = (Auth) Proxy.newProxyInstance(tempProxy.getClass().getClassLoader(), new Class[]{Auth.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(" 111 before ... ");
                Object result = method.invoke(temp2, args);
                System.out.println(" 1111 after ... ");

                return result;
            }
        });


        System.out.println(tempProxy.add(1, 2));

    }

}
