package top.atstudy.basic.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodOOM {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        while (true){
            CglibProxy proxy = new CglibProxy();
            Object obj = proxy.getInstance(new OOMObject());

            list.add(obj);
        }



    }


    private static class CglibProxy implements MethodInterceptor {

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

//            System.out.println(" ===>> before ... ");
            Object result = methodProxy.invokeSuper(obj, objects);
//            System.out.println(" ===>> after ... ");

            return result;
        }
    }

    static class OOMObject{}

}

