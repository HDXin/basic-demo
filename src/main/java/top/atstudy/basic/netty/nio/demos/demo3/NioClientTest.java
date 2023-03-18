package top.atstudy.basic.netty.nio.demos.demo3;

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
    private static final int PORT = 7755;
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

                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {

                        SelectionKey key = iterator.next();
                        if (key.isReadable()) {
                            TimeUnit.MILLISECONDS.sleep(200);

                            // 得到相关的通道
                            SocketChannel sc = (SocketChannel) key.channel();
                            // 得到一个 Buffer
                            ByteBuffer buffer = (ByteBuffer) key.attachment();
                            buffer.clear();

                            // 读取
                            sc.read(buffer);
                            buffer.flip();

                            if (buffer.hasRemaining()) {
                                // 把读到的缓存区数据转换成字符串
                                byte[] msg = new byte[buffer.limit()];
                                buffer.get(msg);
                                String str = new String(msg);
                                System.out.println("server say: " + str);

//                                buffer.compact();
                            }
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
