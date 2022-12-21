package top.atstudy.basic.cmb.enums;

import lombok.Getter;

@Getter
public enum ApiTypeEnum {

    NTQACINF("NTQACINF", "账户详细信息查询NTQACINF"),
    GET_TRAND_INFO("GetTransInfo", "账户交易信息查询GetTransInfo"),
    BB1PAYBH("BB1PAYBH", "企银支付批量经办BB1PAYBH"),
    BB1QRYBT("BB1QRYBT", "企银批量支付批次查询BB1QRYBT"),
    BB1PAYQR("BB1PAYQR", "企银支付业务查询BB1PAYQR"),
    BB1QRYBD("BB1QRYBD", "企银批量支付明细查询BB1QRYBD"),


    ;

    private String code;
    private String desc;

    ApiTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
