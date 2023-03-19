package top.atstudy.basic.netty.nio.demos.demo4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NioClientTest {


    // 定义相关属性
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 7733;
    private static Selector selector;
    private static SocketChannel socketChannel;
    private static String username;

    static {
        try {
            selector = Selector.open();
            // 连接服务器
            socketChannel = socketChannel.open(new InetSocketAddress(HOST, PORT));
            // 设置非阻塞
            socketChannel.configureBlocking(false);
            // 将 channel 注册到 selector
            socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
            // 得到 username
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + " is ok ... ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

        new Thread(() -> readAndWriteHandler()).start();

        // 发送数据给服务器
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(" ===>> " + s);
            socketChannel.write(ByteBuffer.wrap(s.getBytes()));
        }

    }

    public static void readAndWriteHandler() {
        System.out.println("--<< " + new Date());

        while (true) {
            try {
                int readChannels = selector.select();
                if (readChannels > 0) { // 有可以用的通道
                    TimeUnit.MILLISECONDS.sleep(200);

                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {

                        SelectionKey key = iterator.next();
                        if (key.isReadable()) {
                            // 得到相关的通道
                            SocketChannel sc = (SocketChannel) key.channel();

                            ByteBuffer buffer = ByteBuffer.allocate(8192);
                            sc.read(buffer);

                            String str = "server say: " + new String(buffer.array());
                            System.out.println(str);

                        }
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
