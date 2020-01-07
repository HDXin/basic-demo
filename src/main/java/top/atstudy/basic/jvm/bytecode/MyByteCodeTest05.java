package top.atstudy.basic.jvm.bytecode;

/**
 * 方法的动态分派
 * 方法的动态分派涉及到一个重要概念：方法接受者
 * invokevirtual:字节码指令的多态查找流程
 * 方法的重载与方法重写
 * 方法重载时静态的，是编译器行为；方法重写是动态的，是运行期行为；
 */
public class MyByteCodeTest05 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }

}


class Fruit {
    public void test(){
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    public void test(){
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    public void test(){
        System.out.println("Orange");
    }
}
