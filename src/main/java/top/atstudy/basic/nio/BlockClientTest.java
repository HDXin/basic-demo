package top.atstudy.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockClientTest {

    public static void main(String[] args) throws IOException {


        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8989 ));
        FileChannel fileChannel = FileChannel.open(Paths.get("F://temp/11.jpeg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (fileChannel.read(buf) != -1){
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //关闭通道
        fileChannel.close();
        socketChannel.close();
    }

}
