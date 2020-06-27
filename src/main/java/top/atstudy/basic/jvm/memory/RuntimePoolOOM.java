package top.atstudy.basic.jvm.memory;

import java.util.LinkedList;

/**
 * jvm参数：
 * jdk6以前：-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk7开始：-Xms10m -Xmx10m
 * */
public class RuntimePoolOOM {

    public static void main(String[] args){
        int i=1;
        String a = "abcdefghijklmnopqrstuvwxyz";
        LinkedList<String> l=new LinkedList<String>();//保持常量的引用，防止被fullgc收集
        while(true){
            l.add(String.valueOf(a + i).intern());//将常量添加到常量池
        }
    }

}
