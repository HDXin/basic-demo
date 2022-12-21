package top.atstudy.basic.cmb;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import top.atstudy.basic.cmb.config.CmbPayConfig;
import top.atstudy.basic.cmb.demo.DCCryptor;
import top.atstudy.basic.cmb.demo.DCHelper;
import top.atstudy.basic.cmb.enums.ApiTypeEnum;
import top.atstudy.basic.cmb.request.*;
import top.atstudy.basic.cmb.response.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 对接招商api
 */
@Slf4j
public class CmbRemoteApi implements Serializable {

//    @Resource
//    private IdGenerator idGenerator;

//    @Resource
//    private CmbPayConfig config;

    private static Base64.Encoder encoder = Base64.getEncoder();

    private static Base64.Decoder decoder = Base64.getDecoder();

    private static final String ALG_SM = "SM"; // 采用国密算法


    private CmbPayConfig config = new CmbPayConfig();

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 账户详细信息查询NTQACINF
     * api文档地址：https://openbiz.cmbchina.com/developer/UI/Business/CloudDirectConnect/Public/DocumentCenter/DocDetail.aspx?bizkey=DCCT20201214145038074&fabizkey=1&treeID=100040522
     *
     * @param merchantNo    账号
     * @param subMrechantNo 分行号
     */
    public List<NtqacinfResponse.Ntqacinfz> getNtqacinf(String merchantNo, String subMrechantNo) {

        // 1、构建body
        NtqacinfRequest body = new NtqacinfRequest(Arrays.asList(new NtqacinfRequest.NtqacInfx(merchantNo, subMrechantNo)));

        // 2、调用openapi
        String result = this.executeRemoteMethod(body);

        // 3、TODO 业务处理

        NtqacinfResponse resp = JSONUtil.toBean(result, NtqacinfResponse.class);
        System.out.println("{}响应结果：{}"+body.getApiType().getDesc()+JSONUtil.toJsonStr(resp));



        return ListUtil.empty();
    }


    /**
     * 账户交易信息查询GetTransInfo
     * api文档地址：https://openbiz.cmbchina.com/developer/UI/Business/CloudDirectConnect/Public/DocumentCenter/DocDetail.aspx?bizkey=DCCT20201214145038074&fabizkey=1&treeID=100040527
     *
     * @param merchantNo 商户号
     */
    public List<GetTransInfoResponse.Ntqtsinfz> getTransInfo(String merchantNo) {

        // 1、构建body
        GetTransInfoRequest body = new GetTransInfoRequest(Arrays.asList(new GetTransInfoRequest.SdkTsInfx(merchantNo)));

        // 2、调用openapi
        String result = this.executeRemoteMethod(body);

        // 3、TODO 业务处理
        GetTransInfoResponse resp = JSONUtil.toBean(result, GetTransInfoResponse.class);
        System.out.println("{}响应结果：{}"+body.getApiType().getDesc()+JSONUtil.toJsonStr(resp));

        return ListUtil.empty();
    }

    /**
     * 企银支付批量经办BB1PAYBH
     * api文档地址：https://openbiz.cmbchina.com/developer/UI/Business/CloudDirectConnect/Public/DocumentCenter/DocDetail.aspx?bizkey=DCCT20201214175701770&fabizkey=1&treeID=100040328
     *
     * @param params
     */
    public List<Bb1PayBhResponse.Bb1PayBhz1> bb1paybh(Bb1PayBhRequest params) {

        // 1、构建body
        Bb1PayBhRequest body = new Bb1PayBhRequest(params.getBb1bmdbhx1(), params.getBb1paybhx1());

        // 2、调用openapi
        String result = this.executeRemoteMethod(body);

        // 3、TODO 业务处理
        Bb1PayBhResponse resp = JSONUtil.toBean(result, Bb1PayBhResponse.class);
        System.out.println("{}响应结果：{}"+body.getApiType().getDesc()+JSONUtil.toJsonStr(resp));

        return ListUtil.empty();
    }

    /**
     * 企银批量支付批次查询BB1QRYBT
     * api文档地址：https://openbiz.cmbchina.com/developer/UI/Business/CloudDirectConnect/Public/DocumentCenter/DocDetail.aspx?bizkey=DCCT20201214175701770&fabizkey=1&treeID=100040329
     *
     * @return
     */
    public List<Bb1QryBtResponse.Bb1QryBtz1> bb1qrybt() {

        // 1、构建body
        Bb1QrybtRequest body = new Bb1QrybtRequest();

        // 2、调用openapi
        String result = this.executeRemoteMethod(body);

        // 3、TODO 业务处理
        Bb1QryBtResponse resp = JSONUtil.toBean(result, Bb1QryBtResponse.class);
        System.out.println("{}响应结果：{}"+body.getApiType().getDesc()+JSONUtil.toJsonStr(resp));

        return ListUtil.empty();
    }

    /**
     * 企银支付业务查询BB1PAYQR
     * api文档地址：https://openbiz.cmbchina.com/developer/UI/Business/CloudDirectConnect/Public/DocumentCenter/DocDetail.aspx?bizkey=DCCT20201214175701770&fabizkey=1&treeID=100040327
     *
     * @param yurRef
     */
    public List<Bb1PayQrResponse.Bb1PayQrz1> bb1payqr(String yurRef) {

        // 1、构建body
        Bb1PayQrRequest body = new Bb1PayQrRequest();

        // 2、调用openapi
        String result = this.executeRemoteMethod(body);

        // 3、TODO 业务处理
        Bb1PayQrResponse resp = JSONUtil.toBean(result, Bb1PayQrResponse.class);
        System.out.println("{}响应结果：{}"+body.getApiType().getDesc()+JSONUtil.toJsonStr(resp));

        return ListUtil.empty();
    }

    /**
     * 企银批量支付明细查询BB1QRYBD
     * api文档地址：https://openbiz.cmbchina.com/developer/UI/Business/CloudDirectConnect/Public/DocumentCenter/DocDetail.aspx?bizkey=DCCT20201214175701770&fabizkey=1&treeID=100040330
     *
     * @param bthNbr 批次编号
     * @return
     */
    public List<Bb1QryBdResponse.Bb1QryBdz1> bb1qrybd(String bthNbr) {

        // 1、构建body
        Bb1QryBdRequest body = new Bb1QryBdRequest();
        body.setBb1qrybdy1(Arrays.asList(new Bb1QryBdRequest.Bb1QryBdy1(bthNbr)));

        // 2、调用openapi
        String result = this.executeRemoteMethod(body);

        // 3、TODO 业务处理
        Bb1QryBdResponse resp = JSONUtil.toBean(result, Bb1QryBdResponse.class);
        System.out.println("{}响应结果：{}" + body.getApiType().getDesc() + JSONUtil.toJsonStr(resp));

        return ListUtil.empty();
    }

    /**
     * 调用openapi方法
     *
     * @param body
     * @return
     */
    private String executeRemoteMethod(IRequestBody body) {
        final ApiTypeEnum apiType = body.getApiType();
        RequestHead head = this.createHead(apiType.getCode());

        // 3、构建request
        PublicRequest publicRequest = new PublicRequest(head, body);

        // 4、封装请求参数param
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("request", publicRequest);
        JsonObject param = JsonParser.parseString(JSONUtil.toJsonStr(paramMap)).getAsJsonObject();
        System.out.println("{}请求参数, param: {}" + apiType.getDesc() + param.toString());

        // 5、签名处理
        this.buildSignature(param, apiType);

        // 6、加密数据
        String encryptParam = this.encrypt(param, apiType);

        // 7、发送请求
        String result = null;
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("UID", config.getUserid());
            map.put("ALG", ALG_SM);
            map.put("DATA", URLEncoder.encode(encryptParam, "utf-8"));
            map.put("FUNCODE", apiType.getCode());
            System.out.println("{}调用api,param:{}"+apiType.getDesc()+JSONUtil.toJsonStr(map));
            String resp = DCHelper.doPostForm(config.getApiUrl(), map);
            System.out.println("{}响应结果 resp: {}"+apiType.getDesc()+resp);
            try {
                decoder.decode(resp);
            } catch (Exception ex) {
                throw new RuntimeException("请求返回错误！");
            }

            // 处理响应结果（解密 + 验签）
            result = this.verifySignature(resp, apiType);
            System.out.println("{}解密响应结果{}"+apiType.getDesc()+result);
            return result;
        } catch (Exception e) {
            System.out.println("{}请求失败 error： {}"+e.toString());
            throw new RuntimeException(String.format("请求失败 error: %s", e.getMessage()));
        }
    }

    /**
     * 响应结果验签
     *
     * @param resp
     * @return
     */
    private String verifySignature(String resp, ApiTypeEnum apiType) throws Exception {
        // 解密
        String resplain = new String(DCCryptor.CMBSM4DecryptWithCBC(config.getSm4key().getBytes(), getID_IV(), decoder.decode(resp)), StandardCharsets.UTF_8);
        System.out.println("{}响应结果解密 resp: {}"+apiType.getDesc()+resplain);

        // 验签
        JsonObject tempResp = new GsonBuilder().create().fromJson(resplain, JsonObject.class);
        JsonObject signature = tempResp.getAsJsonObject("signature");
        String respSign = signature.get("sigdat").getAsString();
        System.out.println("{}响应结果签名值{} "+apiType.getDesc()+respSign);

        signature.addProperty("sigdat", "__signature_sigdat__");
        tempResp.add("signature", signature);
        String resSignSource = DCHelper.serialJsonOrdered(tempResp);
        System.out.println("{}待验签的响应结果{}"+apiType.getDesc()+resSignSource);
        boolean verify = DCCryptor.CMBSM2VerifyWithSM3(getID_IV(), decoder.decode(config.getBankpubkey()), resSignSource.getBytes(StandardCharsets.UTF_8), decoder.decode(respSign));
        System.out.println("{}验签结果{}"+apiType.getDesc()+verify);
        if (!verify) {
            throw new RuntimeException(String.format("%s验签失败！", apiType.getDesc()));
        }
        return resplain;
    }

    /**
     * 数据加密
     *
     * @param param
     * @return
     */
    private String encrypt(JsonObject param, ApiTypeEnum apiType) {
        try {
            // SM4-CBC加密
            String plaintxt = param.toString();
            System.out.println("{}数据加密前 param: {}"+apiType.getDesc()+plaintxt);
            byte[] enInput = DCCryptor.CMBSM4EncryptWithCBC(config.getSm4key().getBytes(), getID_IV(), plaintxt.getBytes(StandardCharsets.UTF_8));
            String req = new String(encoder.encode(enInput));
            System.out.println("{}数据加密后 param: {}"+apiType.getDesc()+req);
            return req;
        } catch (Exception e) {
            System.out.println("{}数据加密失败 error {}"+apiType.getDesc()+e.toString());
            throw new RuntimeException(String.format("数据加密失败error %s", e.getMessage()));
        }
    }

    /**
     * 构建签名
     *
     * @param param
     */
    private void buildSignature(JsonObject param, ApiTypeEnum apiType) {
        try {
            JsonObject signature = new JsonObject();
            signature.addProperty("sigdat", "__signature_sigdat__");
            signature.addProperty("sigtim", DCHelper.getTime());
            param.add("signature", signature);
            byte[] signature1 = DCCryptor.CMBSM2SignWithSM3(getID_IV(), decoder.decode(config.getPrivkey()), param.toString().getBytes(StandardCharsets.UTF_8));
            String sigdat1 = new String(encoder.encode(signature1));
            signature.addProperty("sigdat", sigdat1);
            System.out.println("{}签名后数据 param: {}"+apiType.getDesc()+param.toString());
        } catch (Exception e) {
            System.out.println("{}签名失败 error {}"+apiType.getDesc()+e.toString());
            throw new RuntimeException(String.format("签名失败error %s", e.getMessage()));
        }
    }

    /**
     * 构建head
     *
     * @param funcode api
     * @return
     */
    private RequestHead createHead(String funcode) {
        RequestHead head = new RequestHead();
        head.setFuncode(funcode);
        head.setUserid(config.getUserid());
        head.setReqid(this.createRequstid());
        return head;
    }

    /**
     * 构建requestid
     *
     * @return
     */
    private String createRequstid() {
        String now = LocalDateTimeUtil.format(LocalDateTime.now(), "yyyyMMddHHmmssSSS");
//        String requestid = String.format("%s%s", now, idGenerator.snowflakeId());
        String requestid = String.format("%s%s", now, RandomUtil.randomLong(10));
        return requestid;
    }

    private byte[] getID_IV() {
        String uid = config.getUserid(); // 请替换为实际的用户UID
        String userid = uid + "0000000000000000";
        return userid.substring(0, 16).getBytes();
    }


}
