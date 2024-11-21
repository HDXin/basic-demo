package top.atstudy.basic.netty.nio.demos.demo4;

import top.atstudy.basic.netty.nio.demos.demo4.server.WorkThreadGroup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 单Reactor多线程
 */
public class NioServerTest {

    private static Selector selector;

    private static WorkThreadGroup group;

    static {
        try {
            selector = Selector.open();
            group = new WorkThreadGroup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("nio server start ... ");

        // 创建 ServerSocketChannel -> ServerSocket
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        // 绑定到一个端口
        ssChannel.bind(new InetSocketAddress(7733));

        // 设置为非阻塞
        ssChannel.configureBlocking(false);

        // 把 ServerSocketChannle 注册到 Selector 上， 事件为：OP_ACCEPT
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(Thread.currentThread().getName() + " server is ok " + new Date());

        // 循环等待客户端连接
        while (true) {
            // 等待 1 秒，如果没有事件发生，返回
            if (selector.select(10) == 0) {
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
                if (key.isAcceptable()) {
                    // 注册接受事件
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    acceptHandler(channel);
                }

                // 手动从集合中移除当前的 selectionkey, 防止重复操作
                keyIterator.remove();
            }
        }
    }


    private static void acceptHandler(ServerSocketChannel ssChannel) {
        System.out.println(Thread.currentThread().getName() + ", acceptHandler ... ");

        //如果是OP_ACCEPT, 有新的客户端连接
        // 该客户端生成一个 SocketChannel
        try {
            final SocketChannel sChannel = ssChannel.accept();
            sChannel.configureBlocking(false);
            new Thread(() -> group.add(sChannel)).start();

            // 将 SocketChannel 注册到 selector, 关注事件为 OP_READ, 同时给 SocketChannel 关联一个Buffer
//            sChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
