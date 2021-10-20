package top.atstudy.basic.lsb;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Lsb {

    /**
     * 加密消息
     */
    private byte[] encryptedMessage;

    private BufferedImage srcImage;

    public Lsb(String filePath) {
        try {
            srcImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encode(String data, String password) {
        try {
            // 将密文转换为 32 位的字节数组
            byte[] shaKey = SecureUtil.sha256().digest(password);
            System.out.println("密码转换 AES Key: " + Base64.encode(shaKey));
            byte[] encrypt = SecureUtil.aes(shaKey).encrypt(data);
            this.encryptedMessage = encrypt;
            System.out.println("写入编码后消息: " + Base64.encode(encrypt));
        } catch (Exception e) {
            throw new RuntimeException("加密失败!", e);
        }
    }

    public void save(String distPath) throws IOException {
        WritableRaster raster = srcImage.getRaster();
        DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();

        byte[] writableBytes = buffer.getData();

        int header = encryptedMessage.length;
        byte[] lenBytes = intToBytes(header);
        int totalLen = 4 + encryptedMessage.length;

        byte[] bytesToHide = new byte[totalLen];

        System.arraycopy(lenBytes, 0, bytesToHide, 0, lenBytes.length);
        System.arraycopy(encryptedMessage, 0, bytesToHide, lenBytes.length, encryptedMessage.length);

        if (bytesToHide.length * 8 > writableBytes.length) {
            throw new RuntimeException("Image too small to hide message");
        }

        int offset = 0;
        for (int i = 0; i < bytesToHide.length; i += 1) {
            byte b = bytesToHide[i];
            for (int j = 0; j < 8; j += 1) {
                int bit = (b >> j) & 1;
                writableBytes[offset] = (byte) ((writableBytes[offset] & 0xFE) | bit);
                offset += 1;
            }
        }
        ImageIO.write(srcImage, "png", new File(distPath));
        System.out.println("图片已保存!");
    }

    public String decode(String password) {
        try {
            byte[] encodedData = showMessage();
            byte[] shaKey = SecureUtil.sha256().digest(password);
            return SecureUtil.aes(shaKey).decryptStr(encodedData);
        } catch (Exception e) {
            return "[解密失败]";
        }
    }

    public byte[] showMessage() {
        byte[] hiddenBytes;
        try {
            WritableRaster raster = srcImage.getRaster();
            DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
            byte[] data = buffer.getData();

            int len = 0;
            int offset = 0;

            System.out.print("消息头: ");
            for (int i = 0; i < 4; i += 1) { // read length header (4 bytes)
                byte b = 0;
                for (int j = 0; j < 8; j += 1) {
                    b |= (data[offset] & 1) << j;
                    offset += 1;
                }
                System.out.print(b);
                System.out.print(' ');
                len |= b << (8 * i);
            }
            System.out.print('\n');
            hiddenBytes = new byte[len];
            for (int i = 0; i < len; i += 1) {
                byte b = 0;
                for (int j = 0; j < 8; j += 1) {
                    b |= (data[offset] & 1) << j;
                    offset += 1;
                }
                hiddenBytes[i] = b;
            }
        } catch (Exception e) {
            throw new NegativeArraySizeException("ERROR! Please Try Again");
        }
        return hiddenBytes;
    }

    private static byte[] intToBytes(int num) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i += 1) {
            bytes[i] = (byte) ((num >> (8 * i)) & 0xFF);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        Lsb lsb = new Lsb("E:\\temp\\images\\_bKih.png");
        lsb.encode("Hello World11", "12311");
        lsb.save("E:\\temp\\images\\0_out.png");

        Lsb decodeLsb = new Lsb("E:\\temp\\images\\0_out.png");
        String message = decodeLsb.decode("12311");
        System.out.println("解密后消息: " + message);
    }

}
