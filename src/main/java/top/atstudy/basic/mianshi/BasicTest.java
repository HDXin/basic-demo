package top.atstudy.basic.mianshi;

import java.util.ArrayList;
import java.util.List;

public class BasicTest {

    public static void main(String[] args) {

        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);

    }

    public static void test01(){
        int i = 0;
        i = i++;
        System.out.println(i);
    }

    public static void test02(){
        int i = 0;
        i++;
        System.out.println(i);
    }

    public static void test03(){
        int i = 0;
        int j = i++;
        System.out.println(i);
    }

    public static void test04(){
        Car car = new Car();
    }

    public static void test05(){
        for (int i = 0; i < 20; i++) {
            Car car = new Car();
        }
    }

    public static void test06(){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Car car = new Car();

            cars.add(car);
        }
    }

}

class Car {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
