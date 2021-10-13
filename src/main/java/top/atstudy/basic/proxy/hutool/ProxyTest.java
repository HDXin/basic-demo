package top.atstudy.basic.proxy.hutool;

import cn.hutool.aop.ProxyUtil;
import top.atstudy.basic.proxy.Auth;
import top.atstudy.basic.proxy.AuthImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/6 20:27
 * @Description
 */
public class ProxyTest {

    public static void main(String[] args) {

        // 测试 jdk proxy
//        testJDKProxy();

        // 测试 proxy
        testProxy();

    }

    private static void testProxy(){

        LogService proxy = ProxyUtil.proxy(new LogService(), new LogAspect());

        System.out.println(proxy.log("你好！"));

    }


    private static void testJDKProxy(){

        Auth a = (Auth) ProxyUtil.newProxyInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(" ===>> before ... ");
                Object result = method.invoke(new AuthImpl(), args);
                System.out.println(" ===>> after ... ");

                return result;
            }
        }, Auth.class);

        System.out.println(a.add(1, 2));

    }

}