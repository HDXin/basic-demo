package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1PayBhResponse implements Serializable {

    private ResponseHead head;

    private Bb1PayBhz1RespBody body;

    @Data
    public static class Bb1PayBhz1RespBody implements Serializable {
        private List<Bb1PayBhz1> bb1paybhz1;
    }

    @Data
    public static class Bb1PayBhz1 implements Serializable {
        /**
         * 批次编号
         */
        private String bthNbr;
        /**
         * 请求状态
         */
        private String reqSts;
        /**
         * 业务处理结果
         */
        private String rtnFlg;
        /**
         * 错误码
         */
        private String errCod;
        /**
         * 错误文本
         */
        private String errTxt;
        /**
         * 提示文本
         */
        private String msgTxt;

    }

}
