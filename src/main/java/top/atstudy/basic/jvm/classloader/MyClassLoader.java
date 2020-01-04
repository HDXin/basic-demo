package top.atstudy.basic.jvm.classloader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyClassLoader {

    public static void main(String[] args) {

        List<Person> ps = new ArrayList<>();
        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    ps.add(new Person("Jerry", 25));
                } catch (Exception e){
                    System.out.println("ex: " + e);
                }
            }
        }).start();

    }

    static class Person {
        private String name;
        private int age;
        private byte[] images = new byte[1024*1024];

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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

        public byte[] getImages() {
            return images;
        }

        public void setImages(byte[] images) {
            this.images = images;
        }
    }

}
