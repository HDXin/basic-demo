package top.atstudy.basic.function;

import java.util.Comparator;
import java.util.function.BiConsumer;
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

        Person p3 = new Person();
        Consumer<Integer> cc = p3::setAge;
        cc.accept(35);
        System.out.println(" ===>> p3： " + p3.toString());


        BiConsumer<Integer, Integer> p5 = Person::compare;
        p5.accept(5, 9);

    }



}

class Person {

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

    public static int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
