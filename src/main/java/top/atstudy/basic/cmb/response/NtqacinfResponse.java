package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class NtqacinfResponse implements Serializable {

    private ResponseHead head;

    private NtqacinfRespBody body;

    @Data
    public static class NtqacinfRespBody implements Serializable {
        private List<Ntqacinfz> ntqacinfz;
    }

    @Data
    public static class Ntqacinfz implements Serializable {
        /**
         * 上日余额
         */
        private String accblv;
        /**
         * 科目
         */
        private String accitm;
        /**
         * 注解
         */
        private String accnam;
        /**
         * 帐号
         */
        private String accnbr;
        /**
         * 可用余额
         */
        private String avlblv;
        /**
         * 分行号
         */
        private String bbknbr;
        /**
         * 币种
         */
        private String ccynbr;
        private String dactyp;
        /**
         * 冻结余额
         */
        private String hldblv;
        /**
         * 年利率
         */
        private String intrat;
        /**
         * 透支额度
         */
        private String lmtovr;
        /**
         * 到期日
         */
        private String mutdat;
        /**
         * 联机余额
         */
        private String onlblv;
        private String opnbbk;
        private String opnbrn;
        /**
         * 开户日
         */
        private String opndat;
        private String relnbr;
        /**
         * 状态
         */
        private String stscod;
    }


}
