package top.atstudy.basic.cmb;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.atstudy.basic.cmb.request.Bb1PayBhRequest;
import top.atstudy.basic.cmb.response.*;

import java.math.BigDecimal;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class CmbRemoteApiTest {

    private CmbRemoteApi cmbRemoteApi = new CmbRemoteApi();

    /**
     * 账户详细信息查询NTQACINF
     */
    @Test
    public void testGetNtqacinf() {
        log.info(" ==>> {}");

        String merchantNo = "755915677210105";
        String subMechantNo = "75";
        List<NtqacinfResponse.Ntqacinfz> resp = this.cmbRemoteApi.getNtqacinf(merchantNo, subMechantNo);
        log.info(" ==>> {}", JSONUtil.toJsonStr(resp));

    }

    /**
     * 获账户交易信息查询GetTransInfo
     */
    @Test
    public void testGetTransInfo() {

        String merchantNo = "755927956310020";
        List<GetTransInfoResponse.Ntqtsinfz> resp = cmbRemoteApi.getTransInfo(merchantNo);
        log.info(" ===>> {}", JSONUtil.toJsonStr(resp));

    }

    /**
     * 企银支付批量经办BB1PAYBH
     */
    @Test
    public void testBb1paybh() {

        Bb1PayBhRequest params = new Bb1PayBhRequest();
        // 汇总信息
        Bb1PayBhRequest.Bb1BmdHx1 bb1BmdHx1 = new Bb1PayBhRequest.Bb1BmdHx1();
        bb1BmdHx1.setBusMod("");
        bb1BmdHx1.setBusCod("N02030");
        bb1BmdHx1.setBthNbr("A000001");
        bb1BmdHx1.setDtlNbr("2");
        bb1BmdHx1.setCtnFlg("N");
        params.setBb1bmdbhx1(Arrays.asList(bb1BmdHx1));

        // 支付信息
        Bb1PayBhRequest.Bb1PayBhx1 bb1PayBhx1 = new Bb1PayBhRequest.Bb1PayBhx1();
        bb1PayBhx1.setDbtAcc("");
        bb1PayBhx1.setCrtAcc("6215123515625689562");
        bb1PayBhx1.setCrtNam("黄德鑫");
        bb1PayBhx1.setCrtBnk("建设银行");
        bb1PayBhx1.setCcyNbr("10");
        bb1PayBhx1.setTrsAmt(new BigDecimal("1.01"));
        bb1PayBhx1.setBnkFlg("N");
        bb1PayBhx1.setNusAge("付费费");
        bb1PayBhx1.setYurRef("X000001");
        bb1PayBhx1.setCtrNbr("N/A");
        bb1PayBhx1.setInvNbr("N/A");

        Bb1PayBhRequest.Bb1PayBhx1 bb1PayBhx12 = new Bb1PayBhRequest.Bb1PayBhx1();
        bb1PayBhx12.setDbtAcc("");
        bb1PayBhx12.setCrtAcc("6215123515625689562");
        bb1PayBhx12.setCrtNam("黄德鑫");
        bb1PayBhx12.setCrtBnk("建设银行");
        bb1PayBhx12.setCcyNbr("10");
        bb1PayBhx12.setTrsAmt(new BigDecimal("2.03"));
        bb1PayBhx12.setBnkFlg("N");
        bb1PayBhx12.setNusAge("付费费");
        bb1PayBhx12.setYurRef("X000002");
        bb1PayBhx12.setCtrNbr("N/A");
        bb1PayBhx12.setInvNbr("N/A");

        params.setBb1paybhx1(Arrays.asList(bb1PayBhx1, bb1PayBhx12));

        List<Bb1PayBhResponse.Bb1PayBhz1> resp = this.cmbRemoteApi.bb1paybh(params);
        log.info(" ==>> {}", JSONUtil.toJsonStr(resp));

    }

    /**
     * 企银批量支付批次查询BB1QRYBT
     */
    @Test
    public void testBb1qrybt() {

        List<Bb1QryBtResponse.Bb1QryBtz1> resp = this.cmbRemoteApi.bb1qrybt();
        log.info(" ===>> {}", JSONUtil.toJsonStr(resp));

    }

    /**
     * 企银支付业务查询BB1PAYQR
     */
    @Test
    public void testBb1payqr() {

        String yurRef = "";
        List<Bb1PayQrResponse.Bb1PayQrz1> resp = this.cmbRemoteApi.bb1payqr(yurRef);
        log.info(" ===>> {}", JSONUtil.toJsonStr(resp));

    }

    /**
     * 企银批量支付明细查询BB1QRYBD
     */
    @Test
    public void testBb1qrybd() {

        String bthNbr = "";
        List<Bb1QryBdResponse.Bb1QryBdz1> resp = this.cmbRemoteApi.bb1qrybd(bthNbr);
        log.info(" ===>> {}", JSONUtil.toJsonStr(resp));

    }


}
