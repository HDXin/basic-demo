package top.atstudy.basic.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader06 extends ClassLoader {

    private String path;
    private String name;

    private final String fileExtension = ".class";

    public MyClassLoader06(String name){
        super();
        this.name = name;
    }

    public MyClassLoader06(ClassLoader parent, String name){
         super(parent);
         this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println(" ===>> findClass: " + name);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name){
        System.out.println(" ===>> loadClassData: " + name);

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

        MyClassLoader06 loader = new MyClassLoader06("loader");
        loader.setPath("F://temp/");
        Class<?> clazz = loader.loadClass("top.atstudy.basic.jvm.classloader.MySample");
        System.out.println(" ===>> clazz: " + clazz.hashCode());
        System.out.println(" === ");
        Object obj = clazz.newInstance();



    }
}
