package top.atstudy.basic.netty.nio.demos.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NioClient2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 10000; i < 20000; i++) {
            final Integer port = i;
//            new Thread(() -> {
//                try {
            createClient(port);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
        }

        TimeUnit.SECONDS.sleep(10000);
    }

    private static void createClient(Integer port) throws IOException {

        // 得到一个网络通道
        SocketChannel sChannel = SocketChannel.open();

        // 设置非阻塞
        sChannel.configureBlocking(false);

        // 提供服务器IP,端口
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 7788);

        // 连接服务器
        if (!sChannel.connect(addr)) {
            while (!sChannel.finishConnect()) {
                System.out.println("正在连接客户端， 可以做其它事情 ... ");
            }
        }


    }

}
