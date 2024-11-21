package top.atstudy.basic.proxy.jdk;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
public class MyInvocationHandler implements InvocationHandler {

    private OrderService orderService;

    public MyInvocationHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("拦截前 ... ");
        Object result = method.invoke(orderService, args);
        System.out.println("拦截后 ... ");
        return result;
    }

    interface OrderService {

        Long create(String name);

    }

    static class OrderServiceImpl implements OrderService {
        @Override
        public Long create(String name) {
            Long orderId = Convert.toLong(RandomUtil.randomNumbers(5));
            System.out.println("创建订单orderId:" + orderId + ",name:" + name);
            return Convert.toLong(orderId);
        }
    }

    public static void main(String[] args) {

        OrderService service = new OrderServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(service);

        OrderService proxy = (OrderService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        Long orderId = proxy.create("优惠单");
        System.out.println(" ===>> result:" + orderId);
    }


}
