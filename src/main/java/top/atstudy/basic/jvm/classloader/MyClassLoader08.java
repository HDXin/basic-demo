package top.atstudy.basic.jvm.classloader;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader08 extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        MyClassLoader06 loader = new MyClassLoader06("loader");
        loader.setPath("F://temp/");
        MyClassLoader06 loader2 = new MyClassLoader06("loader2");
        loader2.setPath("F://temp/");

        Class<?> clazz = loader.loadClass("top.atstudy.basic.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("top.atstudy.basic.jvm.classloader.MyPerson");

        System.out.println(" clazz == clazz2 ? " + (clazz == clazz2));

        Object obj = clazz.newInstance();
        Object obj2 = clazz2.newInstance();

        Method method = clazz.getMethod("setMyPerson", Object.class);
        method.invoke(obj, obj2);

    }
}
