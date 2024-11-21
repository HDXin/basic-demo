package top.atstudy.basic.demo;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

public class WxUtils {

    public static void main(String[] args) {

        String noncestr = "Wm3WZYTPz0wzccnW";
        String jsapiTicket = "kgt8ON7yVITDhtdwci0qeUhuKQZVJg83tzUEtFqEd7rn0LrzobWbRAsveMF7Tr5_N0YqpNsZnhCKlGo1GHHU5g";
        String timestamp = "1414587457";
        String url = "http://www.51alf.cn/study.html";

        String template = "jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s";

        String str = String.format(template, jsapiTicket, noncestr, timestamp, url);

        byte[] data = str.getBytes();
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA1withRSA);
        //签名
        byte[] signed = sign.sign(data);
        System.out.println(new String(signed));


        //验证签名
        boolean verify = sign.verify(data, signed);
        System.out.println(verify);
    }


}
