package top.atstudy.basic.mail;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

public class MailTest {

    public static void main(String[] args) {

        System.out.println(" --->> " + sum(10));



    }

    /**
     * 解析html
     */
    private static void parseHtml(){





    }

    /**
     * 发送邮件测试
     */
    private static void sendMail(){
        MailAccount account = new MailAccount();
        account.setHost("smtp.51alf.cn");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("postmaster@51alf.cn");
        account.setUser("postmaster@51alf.cn");
        account.setPass("Harley2018");

        MailUtil.send(account, CollUtil.newArrayList("897798242@qq.com"), "周报总结", "嗨！这是我的一周总结", false);

        System.out.println("--->> ");
    }


    /**
     * 计算图片浏览时长
     * @param num
     * @return
     */
    private static int sum(int num) {
        int sum = 0;
        int a = 12;
        for (int i = 0; i < num; i++) {

            sum += a;
            if(a > 3){
                a--;
            }
        }
        return sum;
    }

}
