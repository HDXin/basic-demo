package top.atstudy.basic.jvm.bytecode;

import java.util.Date;

/**
 *
 */
public class MyByteCodeTest06 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());

    }

}

class Animal {
    public void test(String str){
        System.out.println("Animal str");
    }
    public void test(Date date){
        System.out.println("Animal date");
    }
}

class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("Dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("Dog date");
    }
}