package top.atstudy.basic.suanfa.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * 1、两个质数：p = 3, q = 11
 * 2、质数相乘：n = 3 x 11 = 33
 * 3、欧拉函数：T = (p - 1)x(q - 1) = 20
 * 4、选公钥：E =（3， 33）
 * a、质数
 * b、1 < 公钥 < T
 * c、不能是T的因子
 * 5、计算私钥：（D x E）% T = 1, D = （7, 33）
 */
public class RSATest {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        test01();


//        test03();


//        test05();

//        test06();


        String s = HttpUtil.get("https://ygy.paat.vip/ygy/pc/home/cert/list?pageSize=10", 5000);
        System.out.println(s);




    }

    private static void test06() {

        X509Certificate var3;
        FileInputStream inputStream = null;
        try {
            String certPath = "E:\\temp\\cert\\_.paat.vip.crt";
            inputStream = new FileInputStream(certPath);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            var3 = (X509Certificate) cf.generateCertificate(inputStream);
            System.out.println("===>> ");
        } catch (Exception var11) {
            throw new RuntimeException(var11);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException var12) {
                throw new RuntimeException(var12);
            }

        }


    }


    private static void test05() {

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqchpkLMdoxio+EUizBav4Y4crjfm2/K+vcZKzfy/HdRKyK+ag9nWWeTs4cTkHyzEN3h4kJzehSjYS21jIgwefMW6J1dR3Q5v9MhTw4ppjqlqS7DAI/RP632Eb8rGtgwSY0DcGiLnOSXQNDQw9sH3NieMdYQF1CpM42V+RBnYAEPpOJb8rsmEUP3nHy0yzWX6u3L9pmMXp44DkUT3qBEBn+Ti57UuyAOZe6C9Yk8TFZnn6NDIULostxMZFO81l12Sljofg19xuCqJbz570mV6OoKA5InklAknOdeS7qk/Nvt7DYxWUhl44SfR4zadFY+C6ZUMfTYLALBvuoFqwPda5wIDAQAB";
        RSA rsa = new RSA(null, publicKey);

        String data = "MIICkDCCAXgCAQAwSzEJMAcGA1UEBhMAMQkwBwYDVQQIEwAxCTAHBgNVBAcTADES\n" +
                "MBAGA1UECgwJ6buE5b636ZGrMQkwBwYDVQQLEwAxCTAHBgNVBAMTADCCASIwDQYJ\n" +
                "KoZIhvcNAQEBBQADggEPADCCAQoCggEBAKnIaZCzHaMYqPhFIswWr+GOHK435tvy\n" +
                "vr3GSs38vx3USsivmoPZ1lnk7OHE5B8sxDd4eJCc3oUo2EttYyIMHnzFuidXUd0O\n" +
                "b/TIU8OKaY6pakuwwCP0T+t9hG/KxrYMEmNA3Boi5zkl0DQ0MPbB9zYnjHWEBdQq\n" +
                "TONlfkQZ2ABD6TiW/K7JhFD95x8tMs1l+rty/aZjF6eOA5FE96gRAZ/k4ue1LsgD\n" +
                "mXugvWJPExWZ5+jQyFC6LLcTGRTvNZddkpY6H4NfcbgqiW8+e9JlejqCgOSJ5JQJ\n" +
                "JznXku6pPzb7ew2MVlIZeOEn0eM2nRWPgumVDH02CwCwb7qBasD3WucCAwEAAaAA\n" +
                "MA0GCSqGSIb3DQEBBAUAA4IBAQBdoG0IXe5st2oK0RX8FlB95gVr5KG2IKk4V8nh\n" +
                "rIxyJ7c1ijxfh464X73IR/YKae6GYsr7Sz5i4IoAnG1bvReao0M6lpqVpkQ68TfU\n" +
                "RNiup84Z0FoeVdqfuyXw91Fc4d1V4i7ydE2j1iS5AihqXnI19NrQ36b4qSq4dERT\n" +
                "RZfhcFydlMttslcuq7g5X9arypgJxspIfz1Bz2qxdV23UIk1CkRJuOYX9SBVFrLx\n" +
                "9ILkTUHnqIxG9tIU6YQC7mwwKm5prO1D8uFAGgdajWhBGyUBji19lG5Qv4x2OJ8C\n" +
                "42jy0JFbwb3JDnpyliqddDLWq9fAjObW50nKrdhdGruIOR49";

        byte[] decrypt = rsa.decrypt(data, KeyType.PublicKey);
        System.out.println(Base64.encode(decrypt));


    }


    private static void test04() {

        KeyPair pair = SecureUtil.generateKeyPair("SM2");

        // SM2 签名：非对称私钥加密
        SM2 sm2 = new SM2(pair.getPrivate(), pair.getPublic());
        String sign = sm2.signHex("abc123456");

        // SM4 加密：对称加密
        String sm4Key = "";

        SymmetricCrypto sm4 = SmUtil.sm4(sm4Key.getBytes());
        sm4.setIv("".getBytes());

        String encryptHex = sm4.encryptBase64("");
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);


    }

    private static void test03() {

        Digester digester = new Digester(DigestAlgorithm.SHA256);
        System.out.println(digester.digestHex("abc123456".getBytes()));
        System.out.println(digester.digestHex("abcxyzlmn".getBytes()));
        System.out.println(digester.digestHex("abcxxxaaa".getBytes()));
        System.out.println(digester.digestHex("abc121212".getBytes()));
        System.out.println(digester.digestHex("abc9090aa".getBytes()));

    }

    private static void test02() {

        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        System.out.println(Base64.decode(pair.getPrivate().getEncoded()));
        System.out.println(Base64.decode(pair.getPublic().getEncoded()));

    }

    private static void test01() throws UnsupportedEncodingException {
        RSA rsa = new RSA();

        // 私钥
        PrivateKey privateKey = rsa.getPrivateKey();
//        System.out.println(" ===>> privateKey " + privateKey);
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        System.out.println(" ===>> privateKeyBase64 " + privateKeyBase64);

        // 公钥
        PublicKey publicKey = rsa.getPublicKey();
//        System.out.println(" ===>> publicKey " + publicKey);
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        System.out.println(" ===>> publicKeyBase64 " + publicKeyBase64);

        //公钥加密，私钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试文本哟，atstudy", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        System.out.println("===>> " + Base64.encode(encrypt));
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        System.out.println(" ===>> " + new String(decrypt));

        //私钥加密，公钥解密
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("我是一段测试文本哟，atstudy", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        System.out.println("===>> " + Base64.encode(encrypt2));
        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
        System.out.println(" ===>> " + new String(decrypt2));

    }

}
