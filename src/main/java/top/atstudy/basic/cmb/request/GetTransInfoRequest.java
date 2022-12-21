package top.atstudy.basic.cmb.request;

import top.atstudy.basic.cmb.enums.ApiTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetTransInfoRequest implements IRequestBody, Serializable {

    private List<SdkTsInfx> sdktsinfx = new ArrayList<>();

    @Override
    public ApiTypeEnum getApiType() {
        return ApiTypeEnum.GET_TRAND_INFO;
    }

    @Data
    public static class SdkTsInfx implements Serializable {

        private String accnbr;

        private String bbknbr;

        private String amtcdr;

        private String bgndat;

        private String c_bbknbr;

        private String enddat;

        private String hghamt;

        private String lowamt;

        public SdkTsInfx() {
        }

        public SdkTsInfx(String accnbr) {
            this.accnbr = accnbr;
        }
    }

    public GetTransInfoRequest() {
    }

    public GetTransInfoRequest(List<SdkTsInfx> sdktsinfx) {
        this.sdktsinfx = sdktsinfx;
    }
}
