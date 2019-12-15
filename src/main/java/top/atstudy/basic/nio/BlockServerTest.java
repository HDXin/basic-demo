package top.atstudy.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockServerTest {

    public static void main(String[] args) throws IOException {

        //1、获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("33.jpeg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

        //2、绑定连接
        ssChannel.bind(new InetSocketAddress(8989));

        //3、
        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (sChannel.read(buf) != -1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        sChannel.close();
        outChannel.close();
        ssChannel.close();

    }

}
