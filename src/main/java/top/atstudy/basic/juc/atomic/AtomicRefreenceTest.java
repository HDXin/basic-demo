package top.atstudy.basic.juc.atomic;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefreenceTest {

    public static void main(String[] args) {

//        demo();

//        demo02();

//        demo03();

        demo04();

//        demo05();

    }

    private static void demo05(){

        Integer a = 128;
        Integer b = 128;
        Integer c = 1000;
        Integer d = 1000;
        System.out.println(a == b);
        System.out.println(c == d);

    }


    private static void demo04(){

        Person p = new Person("Jerry", 10);
        AtomicReference<Person> atomicStringReference = new AtomicReference<Person>(p);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    atomicStringReference.updateAndGet((t) -> {
                        Person a = new Person(t);
                        a.increment();
                        return a;
                    });
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "t-" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ==>> after: " + atomicStringReference.get());
    }

    private static void demo03(){

        AtomicReference<Integer> atomicStringReference = new AtomicReference<Integer>(10);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    atomicStringReference.updateAndGet((t) -> t + 1);
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "t-" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ==>> after: " + atomicStringReference.get());
    }

    private static void demo02(){

        Integer a = 1;
        AtomicReference<Integer> atomicStringReference = new AtomicReference<Integer>(a);
        Integer aa = atomicStringReference.updateAndGet((t) -> t + 1);
        System.out.println("==>> " + aa);

    }

    private static void demo(){
        String initialReference = "hello";
        AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);

        String newReference = "hiahia";
        boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);

        newReference = "hehe";
        exchanged = atomicStringReference.compareAndSet("hiahia", newReference);
        System.out.println("exchanged: " + exchanged);


        exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
        System.out.println("exchanged: " + exchanged);
    }


    static class Person{

        private String name;

        private int age;

        public Person(Person p) {
            this.name = p.getName();
            this.age = p.getAge() + 1;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void increment(){
            this.setAge(this.getAge() + 1);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
