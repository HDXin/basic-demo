package top.atstudy.basic.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader05 extends ClassLoader {

    private String path;
    private String name;

    private final String fileExtension = ".class";

    public MyClassLoader05(String name){
        super();
        this.name = name;
    }

    public MyClassLoader05(ClassLoader parent, String name){
         super(parent);
         this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name){

        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
//            is = new FileInputStream(new File(name + this.fileExtension));
            name = name.replace(".", "/");
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            byte[] data = new byte[1024];
            while ((ch = is.read(data)) != -1){
                baos.write(data, 0, ch);
            }

            return baos.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "MyClassLoader05{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void test(ClassLoader loader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader05 loader = new MyClassLoader05("loader");
        loader.setPath("F://temp/");
        Class<?> clazz = loader.loadClass("top.atstudy.basic.jvm.classloader.Car");
        System.out.println(" ===>> clazz: " + clazz.hashCode());
        System.out.println(" === ");
        Object obj = clazz.newInstance();

        System.out.println(obj);
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());

        System.out.println(" 000000000000000 ");
        MyClassLoader05 loader2 = new MyClassLoader05(loader,"loader2");
        loader2.setPath("F://temp/");
        Class<?> clazz2 = loader2.loadClass("top.atstudy.basic.jvm.classloader.Car");
        System.out.println(" ===>> clazz: " + clazz2.hashCode());
        System.out.println(" === ");
        Object obj2 = clazz2.newInstance();

        System.out.println(obj2);
        System.out.println(obj2.getClass());
        System.out.println(obj2.getClass().getClassLoader());


    }
}
