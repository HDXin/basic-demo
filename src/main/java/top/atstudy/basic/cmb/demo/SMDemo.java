package top.atstudy.basic.cmb.demo;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

/**
 * 国密免前置/SaaS对接示例，本示例仅供参考，不保证各种异常场景运行，请勿直接使用，如有错漏请联系对接人员。运行时，请使用所获取的测试资源替换 用户编号、公私钥、对称密钥、服务商编号等信息。
 */
@Slf4j
public class SMDemo {

    private static String URL = "http://cdctest.cmburl.cn:80/cdcserver/api/v2"; // 银行服务地址(测试)
    private static String bankpubkey = "BNsIe9U0x8IeSe4h/dxUzVEz9pie0hDSfMRINRXc7s1UIXfkExnYECF4QqJ2SnHxLv3z/99gsfDQrQ6dzN5lZj0="; // 银行公钥

    private static String privkey = "NBtl7WnuUtA2v5FaebEkU0/Jj1IodLGT6lQqwkzmd2E=";
    private static String sm4key = "VuAzSWQhsoNqzn0K";//"1234567890123456"; // 用户的对称密钥

    private static Base64.Encoder encoder = Base64.getEncoder();
    private static Base64.Decoder decoder = Base64.getDecoder();

    private static final String ALG_SM = "SM"; // 采用国密算法

    private static String UID = "N002466353"; // 测试的用户编号
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
    
    public static void main(String[] args) throws Exception {
//        HttpUtil httpUtil = new HttpUtil(30);
        String tmp = "lr2kBsFgSgr373U5kO/GIDO6MNE0OuAPmZ4dkJJ2jJkzzyQM2yEazVGDmU771nRgy1yerzYjkkY4uPeA+AxHIUSa9gWl6yETdP8DSXBTH+HLyKE33erGpnQgp7uIn91QrVnOEtgz9FlOsdFETGegH26wlNFBzics9bgAUtVNw1QTUQ7iderkeF6lVANwyFY7e8U5nmD43ILNbHMH4+QTsOz4MNEHq5v4hMAfe2hoJCHLTUxM/nitDS8wILktO3hSfSGWmzaHDpofO8QHH4oaxIYKZjUG99dVn5bBftAQKtTuU/UtFy5CLLGLgORfKRNQDgvWw6A0Atp3Sous9dAVPd1DWavEj2UFmfV/Vzj2aUIVBC0TuDXwP/1bfNyXMGSlc/B+aMJAGS/BTqGj1ug4R30IPGJAEXQjbEkgg2WBuJ65hNfnOQn2/Y5+ChZSkxSi65NuXsbNfPm/GCFxM1X0q70loIJF+FiDImi8APRU3v0QR6mN7yE5+5u9ritgRpDiMFeRT7L+l6iTvnSM/t0bCYTlFxNIMNc70Qk3vMYi7lW1VjUkrack3X3farzLfttum407wrx+X39gGibcw3nqgLASCduL6Ig2KqMY/cmjE+DoLiTuZ6Oj0EWo+3+jWRtsdDUCvpGHDORbwjwbwx6xDnwU/AEQx/eGwu4fvLNIj6S0te/cAC+VY1TCiMwl+6NwGn6rznzLHfjIiFg37uPD3MCQJpn4fPa+C1VLtMwNtH6PtGbFLQw1IAI8lpkKfrDKzSeuv9yZRthl1q+c4Hod//E3PEiMeF4sXz9rZrreYf0nBb7esqttRaK1uRf1HBTzWzPe+KAumkViqOpnM80vewayDMtokOZO9u19w89vO8Vsm67lZVHvHwLkExdXN17u4E3crRt5H08Mk0BtH4ZaxpI6JwR4DHpfVTrkfR6T5SM=";
//
//        String result = httpUtil.postForm(URL, tmp);
//        System.out.println(result);
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());
        Date date = new Date();
        // 引入BC库
        Security.addProvider(new BouncyCastleProvider());

        String ticketID = System.currentTimeMillis()+"";
        ticketID = ticketID.substring(0,7);

        //bb6cdcdlx1 (多记录)
        //bb6cdcbhx1 (单记录)
        // 组织发送报文
        JsonObject obj = new JsonObject();
        JsonObject req = new JsonObject();
        JsonObject body = new JsonObject();
        JsonObject head = new JsonObject();
        head.addProperty("userid", "N002466353");
        head.addProperty("funcode", "BB6BTHHL");
        head.addProperty("reqid", DCHelper.getTime() + "0000001");

        JsonArray array = new JsonArray();
        JsonArray array2 = new JsonArray();
        JsonArray array3 = new JsonArray();
        JsonObject item = new JsonObject();
        JsonObject item2 = new JsonObject();
        JsonObject bb6cdcbhx1  = new JsonObject();

        item2.addProperty("buscod", "N03020");
        item2.addProperty("busmod", "00101");

        bb6cdcbhx1.addProperty("begtag", "Y");
        bb6cdcbhx1.addProperty("endtag", "Y");
        bb6cdcbhx1.addProperty("accnbr", "755915703210605");//账号
        bb6cdcbhx1.addProperty("accnam", "企业网银新20161333");//户名
        bb6cdcbhx1.addProperty("ttlamt", "100");//
        bb6cdcbhx1.addProperty("ttlcnt", "1");//总笔数
        bb6cdcbhx1.addProperty("ttlnum", "1");//总笔数
        bb6cdcbhx1.addProperty("curamt", "100");//本次金额
        bb6cdcbhx1.addProperty("curcnt", "1");//本次笔数
        bb6cdcbhx1.addProperty("ccynbr", "10");//币种
        bb6cdcbhx1.addProperty("nusage", "代发劳务收入");//用途
        bb6cdcbhx1.addProperty("eptdat", ""+format.format(date).toString().replace("-","").substring(0,8));//期望日期 格式：YYYYMMDD
        bb6cdcbhx1.addProperty("yurref", "1919");//
        bb6cdcbhx1.addProperty("chlflg", "N");//结算通道

        item.addProperty("trxseq", ""+ticketID );//交易序号
        item.addProperty("accnbr", "6214831150131511");//账号
        item.addProperty("accnam", "吴极客");//户名
        item.addProperty("trsamt", "100");//交易金额

        item.addProperty("bnkflg", "Y");//Y 行内  N 行外
        item.addProperty("eacbnk", "");//他行户口开户行
        item.addProperty("eaccty", "");//他行户口开户地

        array.add(item);
        array2.add(item2);
        array3.add(bb6cdcbhx1);
        body.add("bb6cdcdlx1", array);
        body.add("bb6cdcbhx1", array3);

        body.add("bb6busmod", array2);
        req.add("head", head);
        req.add("body", body);
        obj.add("request", req);

        log.info(" ==>> \n{}", obj.toString());

//        log.info(" ===>> \n {}", DCHelper.serialJsonOrdered(obj));

        // 请求发送接收
        doProcess(obj);
    }

    private static void doProcess(JsonObject jObject) throws Exception {
        String tmp = "lr2kBsFgSgr373U5kO/GIDO6MNE0OuAPmZ4dkJJ2jJkzzyQM2yEazVGDmU771nRgy1yerzYjkkY4uPeA+AxHIShAaP7iT6b+ynHWFQUOhj/WgSkVEWfx1hA7tZtOMjimKL7a6ISoJVrc/4fwxfRmGm9lHs4nWtyhV5M+1kpEuut0Eq7QpaFh5YyixcGTOQta68zfazpaq3RVZ0WtoONtCpsjbufV0yQpHZDYstWNfMxudNigRkBFr+5DFeHSPkR28N0naXCMRzdwokcIpDwcpJwg9ZPhOCcceNtMM10XlTx5YPhxKk8o1qXK/PsZHXNnpRRC8HxPQpGVv96cI1s/KE8G/YlB5CzbWHyUswq8UoYh6vPvjrJfxBbLP5dILUYHvirquJ9KE8LcxdQofZGAW6msi/Aj2DUyWWGzkjtu8dqrGm7Vny9xWJGtEZ0k7/iirtj6ZVl3DCd5MTx5wc/fOHAfFHX459MQx/nCjRKJd1FIC6iBRX4dAFJmFrIBqyzbh8DgzyRJnCCMRYcXvpUGbfFJMczV75RXzs5MlfGnfZrvxZFcOd1hRGvs9HUKh/a3VOIEkg4eKNi5cryWBhx7Rtm/sVJmWWxf4ThOOjJZHRRN911C0f1O+9aYa3+0ZlgfCvwIGkKBLEsAKBCfT5Gq4+gZ/OYKRSCcbxZit0vQyYaruYAjIXgvUSIxsFOLxkClw7OZus29NT1D1vl0PPBd524/YwHPsgrKNf2qfLuetBq/p2LP1HLTE7nP6KLLaDCW0X7QT410kA1uLRy193ayTJx8XfP5+dGnOtFG2AepECqsFb28pD2IGpBvUUtet3IkXKKZtjrohCR9XcPUMJ3sEDwL5XiFwfnJNpodwMpbH7d1u2WaFvt6sKM+dYbe+dv/0f/ygdtqm+6J5pGaXkLwBXXbs3LAlZh+Uw5EZ77hS04=";

        JsonObject object = new JsonObject();
        // 签名
        object.addProperty("sigdat", "__signature_sigdat__");
        object.addProperty("sigtim", DCHelper.getTime());
        jObject.add("signature", object);
//        String source = DCHelper.serialJsonOrdered(jObject);
        String source = jObject.toString();
        System.out.println("签名原文: " + source);
        byte[] signature1 = DCCryptor.CMBSM2SignWithSM3(getID_IV(), decoder.decode(privkey), source.getBytes(StandardCharsets.UTF_8));
        String sigdat1 = new String(encoder.encode(signature1));
        System.out.println("签名结果: " + sigdat1);
        object.addProperty("sigdat", sigdat1);

        // SM4-CBC加密
        String plaintxt = jObject.toString();
        System.out.println("加密前req:  " + plaintxt);
        byte[] enInput = DCCryptor.CMBSM4EncryptWithCBC(sm4key.getBytes(), getID_IV(), plaintxt.getBytes(StandardCharsets.UTF_8));

        String req = new String(encoder.encode(enInput));
//        req = tmp;
        System.out.println("加密后req:  " + req);

        // 发送请求
        HashMap<String, String> map = new HashMap<>();
        map.put("UID", UID);
        map.put("ALG", ALG_SM);
        map.put("DATA", URLEncoder.encode(req, "utf-8"));
        map.put("FUNCODE", "BB6BTHHL");
        System.out.println("res:  " + map);
        String res = DCHelper.doPostForm(URL, map);
        System.out.println("res:  " + res);
        try {
            decoder.decode(res);
        } catch (Exception e) {
            System.err.println("访问返回错误.");
            return;
        }

        // 解密请求
        String resplain = new String(DCCryptor.CMBSM4DecryptWithCBC(sm4key.getBytes(), getID_IV(), decoder.decode(res)), StandardCharsets.UTF_8);
        System.out.println("res decrypt: " + resplain);

        // 验签
        JsonObject object2 = new GsonBuilder().create().fromJson(resplain, JsonObject.class);
        JsonObject object3 = object2.getAsJsonObject("signature");
        String resSign = object3.get("sigdat").getAsString();
        object3.addProperty("sigdat", "__signature_sigdat__");
        object2.add("signature", object3);
        String resSignSource = DCHelper.serialJsonOrdered(object2);
        System.out.println("验签原文: " + resSignSource);
        System.out.println("验签签名值: " + resSign);
        boolean verify = DCCryptor.CMBSM2VerifyWithSM3(getID_IV(), decoder.decode(bankpubkey), resSignSource.getBytes(StandardCharsets.UTF_8), decoder.decode(resSign));
        System.out.println("验签结果: " + verify);
    }

    private static byte[] getID_IV() {
        String uid = UID; // 请替换为实际的用户UID
        String userid = uid + "0000000000000000";
        return userid.substring(0, 16).getBytes();
    }

}
