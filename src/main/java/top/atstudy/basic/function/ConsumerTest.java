package top.atstudy.basic.function;

import java.util.function.Consumer;

/**
 * consumer: 接受一个对象， 不返回
 *
 * andThen: 先执行当前方法的 accept, 在执行andThen中的accept方法
 */
public class ConsumerTest {

    public static void main(String[] args) {

        Consumer<Person> consuemr = (p) -> {
            p.setAge(25);
        };

        Consumer<Person> andThen = (p) -> {
            p.setAge(p.getAge() + 5);
        };

        Person p = new Person();
        consuemr.accept(p);
        System.out.println(" ==>> p: " + p.toString());

        Person p2 = new Person();
        consuemr.andThen(andThen).accept(p2);
        System.out.println(" ==>> p2: " + p2.toString());


    }



}

class Person{

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
