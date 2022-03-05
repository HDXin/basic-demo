package top.atstudy.basic.message;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * {
 * "msgtype": "text",
 * "text": {
 * "content": "广州今日天气：29度，大部分多云，降雨概率：60%",
 * "mentioned_list":["wangqing","@all"],
 * "mentioned_mobile_list":["13800001111","@all"]
 * }
 * }
 */
public class QywxRobotTextMessage extends AbstractQywxRobotMessage {

    private String text;

    private List<String> userList = new ArrayList<>();

    private List<String> mobileList = new ArrayList<>();

    private QywxRobotTextMessage(String key, String text) {
        super(key, QywxMsgTypeEnum.TEXT);
        this.text = text;
    }

    public static QywxRobotTextMessage create(String key, String text) {
        return new QywxRobotTextMessage(key, text);
    }

    public static QywxRobotTextMessage create(String text) {
        return new QywxRobotTextMessage(null, text);
    }

    public List<String> getUserList() {
        return userList;
    }

    public QywxRobotTextMessage setUserList(List<String> userList) {
        this.userList = userList;
        return this;
    }

    public QywxRobotTextMessage addUser(String user) {
        if (StrUtil.isNotBlank(user)) {
            this.userList.add(user);
        }
        return this;
    }

    public List<String> getMobileList() {
        return mobileList;
    }

    public QywxRobotTextMessage setMobileList(List<String> mobileList) {
        this.mobileList = mobileList;
        return this;
    }

    public QywxRobotTextMessage addMobile(String mobile) {
        if (StrUtil.isNotBlank(mobile)) {
            this.mobileList.add(mobile);
        }
        return this;
    }

    @Override
    public String toBodyText() {
        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("content", this.text);
        if (CollUtil.isNotEmpty(this.getUserList())) {
            contentMap.put("mentioned_list", this.getUserList());
        }
        if (CollUtil.isNotEmpty(this.getMobileList())) {
            contentMap.put("mentioned_mobile_list", this.getMobileList());
        }

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("msgtype", QywxMsgTypeEnum.TEXT.getDesc());
        paramMap.put("text", contentMap);

        return JSONUtil.toJsonStr(paramMap);
    }


    public static void main(String[] args) throws InterruptedException {
        String param = QywxRobotTextMessage.create("哟哟哟切克闹")
                .setUserList(Arrays.asList("Huangdexin"))
//                .setMobileList(Arrays.asList("18737670736"))
                .toBodyText();


        QywxRobotMessageUtil.send(param);

        TimeUnit.SECONDS.sleep(10);
    }
}
