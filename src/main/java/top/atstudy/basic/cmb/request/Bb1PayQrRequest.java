package top.atstudy.basic.cmb.request;

import lombok.Data;
import top.atstudy.basic.cmb.enums.ApiTypeEnum;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1PayQrRequest implements IRequestBody, Serializable {

    private List<Bb1PayQrx1> bb1payqrx1;

    @Override
    public ApiTypeEnum getApiType() {
        return ApiTypeEnum.BB1PAYQR;
    }

    @Data
    public static class Bb1PayQrx1 {
        /**
         * 业务类型
         */
        private String busCod;
        /**
         * 业务参考号
         */
        private String yurRef;
    }

}
