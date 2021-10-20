package top.atstudy.basic.lsb;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/10/14 16:28
 * @Desc:
 */
public class Main {

    private static final byte[] nonce = new byte[32];

    public static void main(String[] args) throws Exception {
        String password = "123";
        String plainText = "hello world";

        byte[] bytes = password.getBytes();

        int slatLen = 32 - bytes.length;
        final byte[] salt = new byte[slatLen];
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.nextBytes(salt);

        byte[] key = new byte[32];
        System.arraycopy(salt, 0, key, 0, salt.length);
        System.arraycopy(bytes, 0, key, slatLen, bytes.length);

//        random.nextBytes(salt);
        // salt + password =  96 + 32
        String cipher = SecureUtil.aes(key).encryptBase64(plainText);
        System.out.println(cipher);

//        byte[] decode = Base64.decode(cipher);
//        byte[] salt_ = Arrays.copyOfRange(decode, 0, 16);
//        byte[] v_ = Arrays.copyOfRange(decode, 16, decode.length);
//
//        // DERIVE key (from password and salt)
//        // DECRYPTION
//        cipher.init(Cipher.DECRYPT_MODE, key, spec);
//        byte[] decryptedCipherTextBytes = cipher.doFinal(v_);
//        String decryptedCipherText = new String(decryptedCipherTextBytes, StandardCharsets.UTF_8);
//        System.out.println(decryptedCipherText);
    }

}
