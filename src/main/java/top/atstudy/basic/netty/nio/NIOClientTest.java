package top.atstudy.basic.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClientTest {

    public static void main(String[] args) throws IOException {

        SocketChannel sChannel = SocketChannel.open();

        sChannel.configureBlocking(false);

        InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 6666);

        if(!sChannel.connect(addr)){

            while (!sChannel.finishConnect()){

                System.out.println("正在连接客户端， 可以做其它事情 ... ");

            }

        }

        String str = "hello netty";
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
        sChannel.write(buf);
        System.in.read();


    }

}
