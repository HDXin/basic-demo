package top.atstudy.basic.thread.park03;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeFooTest {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

//        Simple simple = new Simple();
//        System.out.println(simple.getX());

        //反射拿
//        Simple simple = Simple.class.newInstance();
//        System.out.println(simple.getX());


//        Class.forName("top.atstudy.basic.thread.park03.UnsafeFooTest$Simple");
        Unsafe unsafe = getUnsafe();
        Simple simple = (Simple) unsafe.allocateInstance(Simple.class);
        System.out.println(simple.getX());

        System.out.println(simple.getClass());
        System.out.println(simple.getClass().getClassLoader());

    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            ((Field) f).setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class Simple {

        private long x = 0;
        public Simple(){
            this.x = 1;
        }

        public long getX() {
            return x;
        }
    }


}
