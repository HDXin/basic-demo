package top.atstudy.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BlockServerTest2 {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.bind(new InetSocketAddress(9090));

        SocketChannel sChannel = ssChannel.accept();
        ByteBuffer buf = ByteBuffer.allocate(1024);

        int len = 0;
        while ((len = sChannel.read(buf)) > 0){
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

        buf.put("服务器已成功接收到数据".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        ssChannel.close();

    }

}
