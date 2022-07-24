package top.atstudy.basic.designmode.proxy.hutool;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/10/9 14:49
 * @Desc:
 */
@Slf4j
public class LogService implements Serializable {


    public String log(String str) {

        System.out.println(str);

        return " ==>> " + str;
    }


}
