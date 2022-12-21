package top.atstudy.basic.cmb.request;

import top.atstudy.basic.cmb.enums.ApiTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class NtqacinfRequest implements IRequestBody, Serializable {

    private List<NtqacInfx> ntqacinfx = new ArrayList<>();

    @Override
    public ApiTypeEnum getApiType() {
        return ApiTypeEnum.NTQACINF;
    }

    @Data
    public static class NtqacInfx implements Serializable {

        /**
         * 账号
         */
        private String accnbr;
        /**
         * 分行号
         */
        private String bbknbr;

        public NtqacInfx() {
        }

        public NtqacInfx(String accnbr) {
            this.accnbr = accnbr;
        }

        public NtqacInfx(String accnbr, String bbknbr) {
            this.accnbr = accnbr;
            this.bbknbr = bbknbr;
        }
    }

    public NtqacinfRequest() {
    }

    public NtqacinfRequest(List<NtqacInfx> ntqacinfx) {
        this.ntqacinfx = ntqacinfx;
    }
}
