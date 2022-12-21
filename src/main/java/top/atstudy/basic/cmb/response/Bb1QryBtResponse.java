package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1QryBtResponse implements Serializable {

    private ResponseHead head;

    private Bb1QryBtz1Body body;

    @Data
    public static class Bb1QryBtz1Body implements Serializable {
        private List<Bb1QryBtz1> bb1qrybtz1;
    }

    @Data
    public static class Bb1QryBtz1 implements Serializable {
        /**
         * 批次编号
         */
        private String bthNbr;
        /**
         * 业务类型
         */
        private String busCod;
        /**
         * 业务模式
         */
        private String busMod;
        /**
         * 批次总金额
         */
        private String dtlAmt;
        /**
         * 批次总笔数
         */
        private String dtlNum;
        /**
         * 请求状态：
         * OPR 接收中
         * NTE 待处理
         * FIN 完成
         */
        private String reqSts;
        private String rsv30z;
        /**
         * 业务处理结果：
         * F 失败
         * S 成功
         */
        private String rtnFlg;
        /**
         * 提交成功总金额
         */
        private String sucAmt;
        /**
         * 提交成功总笔数
         */
        private String sucNum;
        /**
         * 经办日期
         */
        private String trsDat;
        /**
         * 经办时间
         */
        private String trsTim;

    }


}
