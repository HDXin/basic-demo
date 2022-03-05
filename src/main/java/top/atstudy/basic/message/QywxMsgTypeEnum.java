package top.atstudy.basic.message;

import lombok.Getter;

@Getter
public enum QywxMsgTypeEnum {

    TEXT("text"),
    MARKDOWN("markdown"),

    ;


    private String desc;
    QywxMsgTypeEnum(String desc) {
        this.desc = desc;
    }
}
