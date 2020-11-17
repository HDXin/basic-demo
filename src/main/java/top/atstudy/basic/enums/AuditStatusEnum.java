package top.atstudy.basic.enums;

import lombok.Getter;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/10/29 16:27
 * @Desc:
 */
@Getter
public enum AuditStatusEnum {

    NEW(1, "待审核"),
    SUCCESSFUL(2, "审核通过"),
    FAIL(3, "驳回");

    private Integer code;
    private String text;
    AuditStatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

}
