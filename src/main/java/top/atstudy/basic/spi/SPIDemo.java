package top.atstudy.basic.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIDemo {

    public static void main(String[] args) {

        ServiceLoader<Math> math = ServiceLoader.load(Math.class);
        Iterator<Math> iterator = math.iterator();
        while (iterator.hasNext()){
            String str = iterator.next().say("hehe");
        }
    }

}
