package top.atstudy.basic.netty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServerTest {

    private static final Selector selector;
    static {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        // 创建 ServerSocketChannel -> ServerSocket
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        // 绑定到一个端口
        ssChannel.bind(new InetSocketAddress(7766));

        // 设置为非阻塞
        ssChannel.configureBlocking(false);

        // 得到一个 Selector
//        Selector selector = Selector.open();

        // 把 ServerSocketChannle 注册到 Selector 上， 事件为：OP_ACCEPT
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端连接
        while (true) {

            // 等待 1 秒，如果没有事件发生，返回
            if (selector.select(1000) == 0) {
//                System.out.println("服务器已经等待了10秒， 无连接 ... ");
                continue;
            }

            // 如果返回的 >0, 就获取到相关的 selectionKey 集合
            // 1、如果返回的 >0, 表示已经获取到关注的事件
            // 2、selector.selectedkeys 返回关注事件的结合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                // 获取到 selectionkey
                SelectionKey key = keyIterator.next();
                //根据key,对应的通道发生的事件做响应的处理
                if (key.isAcceptable()) {//如果是OP_ACCEPT, 有新的客户端连接
                    // 该客户端生成一个 SocketChannel
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);

                    // 将 SocketChannel 注册到 selector, 关注事件为 OP_READ, 同时给 SocketChannel 关联一个Buffer
                    sChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {//发生 OP_READ
//                    key.cancel();
                    readHandler(key);
                }else if(key.isWritable()){
//                    key.cancel();
                    writeHandler(key);
                }

                // 手动从集合中移除当前的 selectionkey, 防止重复操作
                keyIterator.remove();
            }
        }

    }


    private static void readHandler(SelectionKey key) throws IOException {
        System.out.println("read handler ... ");

        // 通过key, 反向获取到对应Channel
        SocketChannel sChannel = (SocketChannel) key.channel();

        // 获取到该 channel 关联的 buffer
        ByteBuffer buf = (ByteBuffer) key.attachment();
        sChannel.read(buf);

        System.out.println(" ===>>" + new String(buf.array()));
        sChannel.register(selector, SelectionKey.OP_WRITE, buf);
    }

    private static void writeHandler(SelectionKey key) throws IOException {

        System.out.println("write handler ... ");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.flip();
        while (buffer.hasRemaining()){
            try{
                client.write(buffer);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        buffer.clear();
        key.cancel();

        client.close();

    }

}
