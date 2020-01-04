package top.atstudy.basic.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyClassLoader07 extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        System.out.println("boot: " + System.getProperty("sun.boot.class.path"));
        System.out.println("extension: " + System.getProperty("java.ext.dirs"));
        System.out.println("app: " + System.getProperty("java.class.path"));

        AESKeyGenerator aes = new AESKeyGenerator();
        System.out.println(aes.getClass().getClassLoader());

    }
}
