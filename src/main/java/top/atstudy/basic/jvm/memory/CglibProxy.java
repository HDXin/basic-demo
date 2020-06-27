package top.atstudy.basic.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object obj){
        this.target = obj;

        Enhancer enhancer = new Enhancer();
        //回调方法
        enhancer.setSuperclass(target.getClass());
        //回调地址
        enhancer.setCallback(this);
        //创建实例
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(" ===>> before ... ");
        Object result = methodProxy.invokeSuper(obj, objects);
        System.out.println(" ===>> after ... ");

        return result;
    }
}
