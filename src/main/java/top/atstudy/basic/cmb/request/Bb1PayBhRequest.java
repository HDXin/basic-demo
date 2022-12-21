package top.atstudy.basic.cmb.request;

import lombok.Data;
import top.atstudy.basic.cmb.enums.ApiTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Bb1PayBhRequest implements IRequestBody, Serializable {

    /**
     * 汇总信息
     */
    private List<Bb1BmdHx1> bb1bmdbhx1;

    /**
     * 支付信息
     */
    private List<Bb1PayBhx1> bb1paybhx1;

    public Bb1PayBhRequest() {
    }

    public Bb1PayBhRequest(List<Bb1BmdHx1> bb1bmdbhx1, List<Bb1PayBhx1> bb1paybhx1) {
        this.bb1bmdbhx1 = bb1bmdbhx1;
        this.bb1paybhx1 = bb1paybhx1;
    }

    @Override
    public ApiTypeEnum getApiType() {
        return ApiTypeEnum.BB1PAYBH;
    }

    @Data
    public static class Bb1BmdHx1 {
        /**
         * 业务类型（业务代码）
         */
        private String busCod;
        /**
         * 业务模式（模式编号）
         */
        private String busMod;
        /**
         * 批次编号
         */
        private String bthNbr;
        /**
         * 总明细笔数
         */
        private String dtlNbr;
        /**
         * 续传标志
         */
        private String ctnFlg;
    }

    @Data
    public static class Bb1PayBhx1 {
        /**
         * 币种
         */
        private String ccyNbr;
        /**
         * 收方帐号
         */
        private String crtAcc;
        /**
         * 收方户名
         */
        private String crtNam;
        /**
         * 收方开户行名称
         */
        private String crtBnk;
        /**
         * 转出帐号
         */
        private String dbtAcc;
        /**
         * 用途
         */
        private String nusAge;
        /**
         * 相应金额
         */
        private BigDecimal trsAmt;
        /**
         * 业务参考号
         */
        private String yurRef;
        /**
         * 系统内标志
         */
        private String bnkFlg;

        private String ctrNbr;

        private String invNbr;
    }


}
