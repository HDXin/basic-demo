package top.atstudy.basic.designmode.flyweight.proxy.jdk;

public class MathImpl implements Math {
    @Override
    public int add(int x, int y) {
        System.out.println(" == add ");
        return x + y;
    }

    @Override
    public int sub(int x, int y) {
        System.out.println(" == sub ");
        return java.lang.Math.max(x, y) - java.lang.Math.min(x, y);
    }

    @Override
    public int mul(int x, int y) {
        System.out.println(" == mul ");
        return x * y;
    }

    @Override
    public int dev(int x, int y) {
        System.out.println(" == dev ");
        return x/y;
    }
}
