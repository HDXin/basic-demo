package top.atstudy.basic.jvm.classloader;

public class MyCat {

    static {
        System.out.println(" load my cat ... ");
    }

    public MyCat() {
        System.out.println(" my cat ... " + this.getClass().getClassLoader());

        System.out.println(" my sample class " + MySample.class);
    }
}
