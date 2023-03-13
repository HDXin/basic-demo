package top.atstudy.basic.netty.nio.selector.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NioClientTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 2; i++) {
            createClient();
        }


        TimeUnit.SECONDS.sleep(1000000);


    }

    public static void createClient() {

        try {
            // 得到一个网络通道
            SocketChannel sChannel = SocketChannel.open();

            // 设置非阻塞
            sChannel.configureBlocking(false);

            // 提供服务器IP,端口
            InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 7755);

            // 连接服务器
            if (!sChannel.connect(addr)) {
                while (!sChannel.finishConnect()) {
                    System.out.println("正在连接客户端， 可以做其它事情 ... ");
                }
            }

            // 如果连接成功，就发送数据
            String str = "hello nio";
            // Wraps a byte array into a buffer
            ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
            // 发送数据，将byte数据发送到channel
            sChannel.write(buf);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
