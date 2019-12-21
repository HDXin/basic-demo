package top.atstudy.basic.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannelTest03 {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("F://temp/test.txt");
        FileChannel inChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("F://temp/test02.txt");
        FileChannel outChanell = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1);
        while (inChannel.read(buf) != -1){
            buf.flip();
            outChanell.write(buf);

            buf.clear();
        }
        outChanell.close();
        inChannel.close();
        fis.close();
        fos.close();

    }

}
