package top.atstudy.basic.designmode.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoProxyClient {

    public void test() {
        System.out.println(" ===>> ");
    }

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "e:\\tmp\\proxy");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AuthImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println(" ===>> before ... ");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println(" ===>> after ... ");

                return result;
            }
        });

        AuthImpl proxy = (AuthImpl) enhancer.create();
        System.out.println(proxy.add(1, 2));

    }

}
