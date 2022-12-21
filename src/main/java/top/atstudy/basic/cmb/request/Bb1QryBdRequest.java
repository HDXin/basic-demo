package top.atstudy.basic.cmb.request;

import lombok.Data;
import top.atstudy.basic.cmb.enums.ApiTypeEnum;

import java.io.Serializable;
import java.util.List;

@Data
public class Bb1QryBdRequest implements IRequestBody, Serializable {

    private List<Bb1QryBdy1> bb1qrybdy1;

    @Override
    public ApiTypeEnum getApiType() {
        return ApiTypeEnum.BB1QRYBD;
    }

    @Data
    public static class Bb1QryBdy1 {

        private String bthNbr;

        private String autStr;

        private String rtnStr;

        private String ctnKey;

        public Bb1QryBdy1() {
        }

        public Bb1QryBdy1(String bthNbr) {
            this.bthNbr = bthNbr;
        }
    }
}
