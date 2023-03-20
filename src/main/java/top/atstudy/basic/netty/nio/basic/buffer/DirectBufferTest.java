package top.atstudy.basic.netty.nio.basic.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/14 21:16
 * @Description
 */
public class DirectBufferTest {

    private static ByteBuffer buf;

    private static int index = 0;

    static {
        buf = ByteBuffer.allocateDirect(10);
    }

    public static void main(String[] args) throws IOException {

        // test copy
        CountVO vo = new CountVO();
//        ByteBuffer b = ByteBuffer.allocateDirect(1024 * 1024 * 1000);
        ByteBuffer b = ByteBuffer.allocate(1024 * 1024 * 1000);
        for (int i = 0; i < 100; i++) {
            copyTest(vo, b);
        }

        System.out.println(String.format(" 总和：%s, %s", vo.getC(), vo.c()));

    }

    public static void copyTest(CountVO vo, ByteBuffer b) throws IOException {

        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream(new File("E:\\temp\\ideaIU-2020.2.4.exe"));
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream(new File("E:\\temp\\xxx-" + (++index) + ".exe"));
        FileChannel fosChannel = fos.getChannel();
        while (fisChannel.read(b) != -1) {
            b.flip();
            fosChannel.write(b);
            b.clear();
        }

        fisChannel.close();
        fosChannel.close();
        long end = System.currentTimeMillis();

        System.out.println(String.format(" ==>> [%s] times: %s ", index, (end - start)));
        vo.addC(end - start);
    }


}