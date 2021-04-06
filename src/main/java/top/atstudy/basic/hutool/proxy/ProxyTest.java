package top.atstudy.basic.hutool.proxy;

import cn.hutool.aop.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/6 20:27
 * @Description
 */
public class ProxyTest {

    public static void main(String[] args) {

        // 测试 jdk proxy
        testJDKProxy();

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