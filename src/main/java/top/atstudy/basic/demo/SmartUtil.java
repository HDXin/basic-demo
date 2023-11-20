package top.atstudy.basic.demo;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmartUtil {

    public static void main(String[] args) {

        String url = "https://www.tianyancha.com/search?key=%E8%9C%97%E7%89%9B";
        String resp = HttpUtil.get(url, 10000);

        System.out.println(resp);

    }

}
