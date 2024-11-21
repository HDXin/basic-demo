package top.atstudy.basic.suanfa.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

public class AESTest {

    public static void main(String[] args) {

        // AES
        test01();



    }

    public static void test02(){




    }

    public static void test01() {
        String content = "test中文";

        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println("key: " + Base64.encode(key));

        // 构建
        AES aes = SecureUtil.aes(key);

        // 加密
        byte[] encrypt = aes.encrypt(content);
        System.out.println("after encrypt: " + Base64.encode(encrypt));

        // 解密
        byte[] decrypt = aes.decrypt(encrypt);
        System.out.println("after decrypt: " + new String(decrypt));

        // 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println("after encrypt: " + encryptHex);

        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("after decrypt: " + decryptStr);

    }

}
