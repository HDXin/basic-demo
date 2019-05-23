package top.atstudy.basic.jvm.gc;

import java.util.Random;

public class G1GCDemo {


    public static void main(String[] args) {
        System.out.println(" ===>> Serial GC demo");
        try {
            String str = "atstudy";
            while (true){
                str += str + new Random().nextInt(111111) + new Random().nextInt(22222222);
                str.intern();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
