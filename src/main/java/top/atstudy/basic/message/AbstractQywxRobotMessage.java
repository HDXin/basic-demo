package top.atstudy.basic.message;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;

public abstract class AbstractQywxRobotMessage implements Serializable {

    private static final String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=%s";

    private String key;

    private QywxMsgTypeEnum msgtype;

    public AbstractQywxRobotMessage(String key, QywxMsgTypeEnum msgtype) {
        this.key = key;
        this.msgtype = msgtype;
    }

    public abstract String toBodyText();

    public void setKey(String key) {
        this.key = key;
    }

    public String getApiUrl(){

        if(StrUtil.isBlank(key)){
            return null;
        }

        return String.format(BASE_URL, this.key);
    }

}
