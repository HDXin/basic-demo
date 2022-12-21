package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GetTransInfoResponse implements Serializable {

    private ResponseHead head;

    private GetTransInfoRespBody body;

    @Data
    public static class GetTransInfoRespBody implements Serializable {
        private List<Ntqtsinfz> ntqtsinfz;
    }


    @Data
    public static class Ntqtsinfz implements Serializable {
        /**
         * 借贷标记
         */
        private String amtcdr;
        private String apdflg;
        /**
         * 有否附件信息标志
         */
        private String athflg;
        /**
         * 分行号
         */
        private String bbknbr;
        /**
         * 业务名称
         */
        private String busnam;
        private String c_athflg;
        /**
         * 分行名称
         */
        private String c_bbknbr;
        private String c_etydat;
        /**
         * 母/子公司所在地区
         */
        private String c_gsbbbk;
        /**
         * 收/付方开户地区
         */
        private String c_rpybbk;
        private String c_trsamt;
        private String c_trsamtc;
        private String c_trsblv;
        private String c_vltdat;
        /**
         * 交易日
         */
        private String etydat;
        /**
         * 交易时间
         */
        private String etytim;
        /**
         * 扩展摘要
         */
        private String narext;
        /**
         * 摘要
         */
        private String naryur;
        /**
         * 流水号
         */
        private String refnbr;
        /**
         * 商务支付订单号
         */
        private String refsub;
        /**
         * 收/付方帐号
         */
        private String rpyacc;
        /**
         * 收/付方开户行地址
         */
        private String rpyadr;
        /**
         * 收/付方开户行名
         */
        private String rpybnk;
        /**
         * 收/付方名称
         */
        private String rpynam;
        private String rsv30z;
        private String rsv31z;
        /**
         * 冲帐标志
         */
        private String rsvflg;
        /**
         * 借方金额
         */
        private String trsamtd;
        /**
         * 贷方金额
         */
        private String trsamtc;
        /**
         * 交易分析码
         */
        private String trsanl;
        /**
         * 余额
         */
        private String trsblv;
        /**
         * 交易类型
         */
        private String trscod;
        /**
         * 起息日
         */
        private String vltdat;
        /**
         * 业务参考号
         */
        private String yurref;

    }

}
