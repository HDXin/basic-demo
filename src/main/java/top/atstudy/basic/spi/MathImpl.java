package top.atstudy.basic.spi;

public class MathImpl implements Math {
    @Override
    public String say(String str) {
        System.out.println(" ==>> say: " + str);

        return "say:" + str;
    }
}
