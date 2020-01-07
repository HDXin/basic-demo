package top.atstudy.basic.jvm.bytecode;

/**
 * 方法的静态分派
 * Grandpa g1 = new Father();
 * g1的静态类型是： Grandpa, 而g1的实际类型（真正指向的类型）是Father
 * 我们可以得出这样的结论：变量的静态类型是不会发生变化的，而变量的实际类型是可以发生变化的（多态的一种体现），
 * 实际类型是在运行期方可确定
 */
public class MyByteCodeTest04 {

    /**
     * 方法重载，是一种静态行为，编译器就可以完全确定
     * @param grandpa
     */
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {

        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyByteCodeTest04 test04 = new MyByteCodeTest04();
        test04.test(g1);
        test04.test(g2);

    }

}

class Grandpa{

}

class Father extends Grandpa {

}

class Son extends Father {

}
