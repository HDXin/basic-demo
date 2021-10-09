package top.atstudy.basic.hutool.proxy;

import cn.hutool.aop.aspects.Aspect;

import java.lang.reflect.Method;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/10/9 14:58
 * @Desc:
 */
public class LogAspect implements Aspect {

    @Override
    public boolean before(Object o, Method method, Object[] objects) {
        System.out.println(" ==>> before ... ");
        return true;
    }

    @Override
    public boolean after(Object o, Method method, Object[] objects, Object o1) {
        System.out.println(" ==>> after ... ");
        return true;
    }

    @Override
    public boolean afterException(Object o, Method method, Object[] objects, Throwable throwable) {
        System.out.println(" ==>> after exception ... ");
        return false;
    }

}
