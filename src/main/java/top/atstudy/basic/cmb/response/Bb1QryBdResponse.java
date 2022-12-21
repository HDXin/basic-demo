package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1QryBdResponse implements Serializable {

    @Data
    public static class Bb1QryBdRespBody {


        private List<Bb1QryBdz1> bb1qrybdz1;

    }

    @Data
    public static class Bb1QryBdz1 {
        /**
         * 系统内标志
         * Y 系统内
         * N系统外
         */
        private String bnkFlg;
        /**
         * 收方行号
         */
        private String brdNbr;
        /**
         * 批次编号
         */
        private String bthNbr;
        /**
         * 币种
         */
        private String ccyNbr;
        /**
         * 网银互联协议号
         */
        private String cnvNbr;
        /**
         * 优惠劵编号
         */
        private String copNbr;
        private String couCod;
        /**
         * 收方帐号
         */
        private String crtAcc;
        /**
         * 收方分行号
         */
        private String crtBbk;
        /**
         * 收方户名
         */
        private String crtNam;
        /**
         * 收方编号
         */
        private String crtSqn;
        /**
         * 城市码
         */
        private String ctyCod;
        /**
         * 转出帐号
         */
        private String dbtAcc;
        /**
         * 转出分行号
         */
        private String dbtBbk;
        /**
         * 虚拟户编号
         */
        private String dmaNbr;
        /**
         * 直汇普通标志
         */
        private String drpFlg;
        /**
         * 期望日
         */
        private String eptDat;
        /**
         * 期望时间
         */
        private String eptTim;
        /**
         * 失败原因
         */
        private String errTxt;
        private String inpTel;
        private String issRef;
        private String kjtAcc;
        /**
         * 提示信息
         */
        private String msgTxt;
        /**
         * 网银互联业务类型编码
         */
        private String npsTyp;
        /**
         * 通知方式一
         */
        private String ntfCh1;
        /**
         * 通知方式二
         */
        private String ntfCh2;
        /**
         * 用途
         */
        private String nusAge;
        /**
         * 通道号
         */
        private String pasNbr;
        private String payTyp;
        /**
         * 行内收方账号户名校验
         */
        private String rcvChk;
        /**
         * 非居民附言编号
         */
        private String remNbr;
        /**
         * AUT	等待审批
         * NTE	终审完毕
         * BNK，WRF	银行处理中
         * FIN	完成
         * OPR	数据接收中
         * APW银行人工审批
         * WRF 可疑，表示状态未知，需要人工介入处理
         */
        private String reqSts;
        private String rsvAmt;
        private String rsvNa1;
        private String rsvNa2;
        private String rsvNb1;
        private String rsvNb2;
        /**
         * 处理结果
         * reqSts =’FIN’时，rtnFlg才有意义；
         * reqSts =’FIN’并且RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理。
         * 返回结果：
         * S	成功	银行支付成功
         * F	失败	银行支付失败
         * B	退票	银行支付被退票
         * R	否决	企业审批否决
         * D	过期	企业过期不审批
         * C	撤消	企业撤销
         */
        private String rtnFlg;
        private String splC80;
        /**
         * 结算通道
         * G 普通
         * Q 快速
         * R 实时-超网
         */
        private String stlChn;
        /**
         * 交易金额
         */
        private String trsAmt;
        /**
         * 业务种类编码
         */
        private String trsCat;
        /**
         * 业务种类
         * 100001    普通汇兑 （默认值）
         * 101001    慈善捐款
         * 101002    其他
         */
        private String trsTyp;
        private String trxAmt;
        private String trxCod;
        /**
         * 参考号
         */
        private String yurRef;

    }

}
