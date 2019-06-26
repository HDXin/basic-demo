package top.atstudy.basic.jvm.exception;

import java.util.Random;

public class ExceptionDemo {
    public static void main(String[] args) {
        //cpu占比高
        cpuDemo();
    }
    public static void cpuDemo(){
        while (true){
            System.out.println(" ===>> " + new Random().nextInt());
        }
    }
}
