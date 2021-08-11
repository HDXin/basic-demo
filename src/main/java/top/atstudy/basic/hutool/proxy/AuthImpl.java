package top.atstudy.basic.hutool.proxy;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/6 20:28
 * @Description
 */
public class AuthImpl implements Auth {

    @Override
    public int add(int a, int b) {
        System.out.println(a + " + " + b);
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println(a + " - " + b);
        return Math.max(a, b) - Math.min(a, b);
    }

}