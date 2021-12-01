package top.atstudy.basic.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoProxyClient {

    public void test() {
        System.out.println(" ===>> ");
    }

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DemoProxyClient.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println(" ===>> before ... ");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println(" ===>> after ... ");

                return result;
            }
        });

        DemoProxyClient client = (DemoProxyClient) enhancer.create();
        client.test();

    }

}
