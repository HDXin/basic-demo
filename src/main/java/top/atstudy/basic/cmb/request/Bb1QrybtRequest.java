package top.atstudy.basic.cmb.request;

import lombok.Data;
import top.atstudy.basic.cmb.enums.ApiTypeEnum;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1QrybtRequest implements IRequestBody, Serializable {

    private List<Bb1QryBtx1> bb1qrybtx1;

    @Override
    public ApiTypeEnum getApiType() {
        return ApiTypeEnum.BB1QRYBT;
    }

    @Data
    public static class Bb1QryBtx1 implements Serializable {

        /**
         * 起始日期
         */
        private String begDat;
        /**
         * 结束日期
         */
        private String endDat;
        /**
         * 请求状态
         */
        private String autStr;
        /**
         * 处理结果
         */
        private String rtnStr;


    }

}
