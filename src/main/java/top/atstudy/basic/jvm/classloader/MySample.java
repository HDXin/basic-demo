package top.atstudy.basic.jvm.classloader;

public class MySample {

    static {
        System.out.println(" load my sample ... ");
    }

    public MySample() {
        System.out.println(" my sample ... " + this.getClass().getClassLoader());
        new MyCat();
    }
}
