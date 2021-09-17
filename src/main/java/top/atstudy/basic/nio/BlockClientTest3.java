package top.atstudy.basic.nio;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class BlockClientTest3 {

    public static void main(String[] args) throws IOException {

        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN) + "\t" + str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();

        }
        sChannel.shutdownOutput();

        //接收服务器的反馈
        int len = 0;
        while ((len = sChannel.read(buf)) != -1){
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

//        inChannel.close();
        sChannel.close();
    }

}
