package top.atstudy.basic.jvm.classloader;

public class MyClassLoader04 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getClass().getClassLoader());
        System.out.println(" ===>> ");

        arrLoad();

    }

    /**
     * 数组类加载
     */
    private static void arrLoad(){

        String[] strs = new String[2];
        System.out.println(strs.getClass());
        System.out.println(strs.getClass().getClassLoader());

        System.out.println(" === ");

        MyClassLoader04[] my = new MyClassLoader04[5];
        System.out.println(my.getClass());
        System.out.println(my.getClass().getClassLoader());

        System.out.println(" === ");
        int[] ints = new int[3];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getClassLoader());

    }

    /**
     * 反射类加载顺序
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void refreload() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getClass().getClassLoader());

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("top.atstudy.basic.jvm.classloader.Car");

        System.out.println(" === ");
        Car car = (Car) clazz.newInstance();
        System.out.println(car.toString());

    }

}


