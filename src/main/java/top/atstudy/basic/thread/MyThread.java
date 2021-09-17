package top.atstudy.basic.thread;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.druid.sql.visitor.functions.Char;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/2/28 23:16
 */
public class MyThread extends Thread {

    private static Integer ticket = 20;

    @Override
    public void run() {
        while(ticket > 0){
            synchronized (Object.class){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + " ... " + ticket);
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    ticket--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

//        MyThread t1 = new MyThread();
//        t1.start();
//
//        MyThread t2 = new MyThread();
//        t2.start();

    }

}
