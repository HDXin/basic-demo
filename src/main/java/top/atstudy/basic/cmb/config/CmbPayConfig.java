package top.atstudy.basic.cmb.config;

import lombok.Data;

@Data
public class CmbPayConfig {

    /**
     * 用户ID
     */
//    private String userid = "N009777874";
    private String userid = "N002462588";

    /**
     * 接口地址
     */
    private String apiUrl = "http://cdctest.cmburl.cn:80/cdcserver/api/v2";

    /**
     * 银行公钥
     */
//    private String bankpubkey = "BNsIe9U0x8IeSe4h/dxUzVEz9pie0hDSfMRINRXc7s1UIXfkExnYECF4QqJ2SnHxLv3z/99gsfDQrQ6dzN5lZj0=";
    private String bankpubkey = "BNsIe9U0x8IeSe4h/dxUzVEz9pie0hDSfMRINRXc7s1UIXfkExnYECF4QqJ2SnHxLv3z/99gsfDQrQ6dzN5lZj0=";

    /**
     * 用户私钥
     */
//    private String privkey = "NBtl7WnuUtA2v5FaebEkU0/Jj1IodLGT6lQqwkzmd2E=";
    private String privkey = "NBtl7WnuUtA2v5FaebEkU0/Jj1IodLGT6lQqwkzmd2E=";

    /**
     * 对称秘钥
     */
//    private String sm4key = "VuAzSWQhsoNqzn0K";
    private String sm4key = "VuAzSWQhsoNqzn0K";


}
