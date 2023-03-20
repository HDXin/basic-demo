package top.atstudy.basic.netty.nio.demos.demo4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NioClient2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 10000; i < 10015; i++) {
            final Integer port = i;
            new Thread(() -> {
                try {
                    createClient(port);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(10000);
    }

    private static void createClient(Integer port) throws IOException {

        // 得到一个网络通道
        SocketChannel sChannel = SocketChannel.open();

        // 设置非阻塞
        sChannel.configureBlocking(false);

        // 提供服务器IP,端口
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 7733);

        // 连接服务器
        if (!sChannel.connect(addr)) {
            while (!sChannel.finishConnect()) {
//                System.out.println(Thread.currentThread().getName() + " 正在连接客户端， 可以做其它事情 ... ");
            }
        }
        System.out.println("client: " + Thread.currentThread().getName() + " 已连接服务端，正在发送消息 ... ");

        for (int i = 0; i < 10; i++) {
            String msg = Thread.currentThread().getName() + ": " + i + " \n";
            sChannel.write(ByteBuffer.wrap(msg.getBytes()));

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
