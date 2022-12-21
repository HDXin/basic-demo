package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1PayQrResponse implements Serializable {

    private ResponseHead head;

    private Bb1PayQrRespBody body;

    @Data
    public static class Bb1PayQrRespBody implements Serializable {
        private List<Bb1PayQrz1> bb1payqrz1;

    }

    @Data
    public static class Bb1PayQrz1 implements Serializable {
        /**
         * 是否有附件信息
         */
        private String athFlg;
        /**
         * 系统内外标志
         * Y 系统内
         * N系统外
         */
        private String bnkFlg;
        /**
         * 业务编码
         */
        private String busCod;
        /**
         * 业务模式
         */
        private String busMod;
        /**
         * 业务摘要
         */
        private String busNar;
        /**
         * 币种
         */
        private String ccyNbr;
        /**
         * 收方帐号
         */
        private String crtAcc;
        /**
         * 收方行地址
         */
        private String crtAdr;
        /**
         * 收方分行号
         */
        private String crtBbk;
        /**
         * 收方行名称
         */
        private String crtBnk;
        /**
         * 收方名称
         */
        private String crtNam;
        /**
         * 付方帐号
         */
        private String dbtAcc;
        /**
         * 转出分行号
         */
        private String dbtBbk;
        /**
         * 付方帐户名
         */
        private String dbtNam;
        /**
         * 付方记账子单元编号
         */
        private String dmaNbr;
        /**
         * 期望日
         */
        private String eptDat;
        /**
         * 期望时间
         */
        private String eptTim;
        /**
         * 用户名
         */
        private String lgnNam;
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
         * 操作别名
         * 001：一级操作
         * 002：二级操作
         * 以此类推
         */
        private String oprAls;
        /**
         * 经办日期
         */
        private String oprDat;
        /**
         * 待处理操作序列
         */
        private String oprSqn;
        /**
         * 收方大额行号
         */
        private String rcvBrd;
        /**
         * 流程实例号
         */
        private String reqNbr;
        /**
         * 请求状态
         * AUT	等待审批
         * NTE	终审完毕
         * BNK	银行处理中
         * FIN	完成
         * OPR	数据接收中
         */
        private String reqSts;
        private String rsv30z;
        /**
         * 业务处理结果
         * reqSts =’FIN’时，rtnFlg才有意义；
         * reqSts =’FIN’并且RTNFLG=’F’，表示支付失败；否则表示支付已被银行受理。
         * <p>
         * 返回结果：
         * S	成功	银行支付成功
         * F	失败	银行支付失败
         * B	退票	银行支付被退票
         * R	否决	企业审批否决
         * D	过期	企业过期不审批
         * C	撤消	企业撤销
         */
        private String rtnFlg;
        /**
         * 失败原因
         */
        private String rtnNar;
        /**
         * 结算通路
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
         * 业务种类
         * 100001    普通汇兑 （默认值）
         * 101001    慈善捐款
         * 101002    其他
         */
        private String trsTyp;
        /**
         * 账务流水
         */
        private String trxSeq;
        /**
         * 账务套号
         */
        private String trxSet;
        /**
         * 用户姓名
         */
        private String usrNam;
        /**
         * 参考号
         */
        private String yurRef;



    }

}
