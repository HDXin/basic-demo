package top.atstudy.basic.netty.nio.demos.demo4.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WorkThread implements Runnable {

    private final Selector selector;

    public WorkThread() throws IOException {
        this.selector = Selector.open();
    }

    @Override
    public void run() {

        while (true) {
            try {
                // 等待 1 秒，如果没有事件发生，返回
                if (selector.select(10) == 0) {
//                System.out.println("服务器已经等待了1秒， 无连接 ... ");
                    continue;
                }
//                TimeUnit.MILLISECONDS.sleep(200);

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        // 读事件
                        readHandler(key);
                    } else if (key.isWritable()) {
                        // 写事件
                        writeHandler(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void readHandler(SelectionKey key) {
        System.out.println(Thread.currentThread().getName() + ", readHandler ... ");

        try {

            // 通过key, 反向获取到对应Channel
            SocketChannel sChannel = (SocketChannel) key.channel();

            // 获取到该 channel 关联的 buffer
            ByteBuffer buf = ByteBuffer.allocate(4096);
            sChannel.read(buf);

            // 绑定缓存区
            String msg = "hi, " + new String(buf.array());
            System.out.println(Thread.currentThread().getName() + " \nclient say: " + new String(buf.array()));

//            sChannel.write(ByteBuffer.wrap(msg.getBytes()));

//            sChannel.register(selector, SelectionKey.OP_WRITE, ByteBuffer.wrap(msg.getBytes()));

            // 注册写事件
            key.attach(ByteBuffer.wrap(msg.getBytes()));
            key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void writeHandler(SelectionKey key) {
        System.out.println(Thread.currentThread().getName() + ", writeHancler ... ");

        try {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buf = (ByteBuffer) key.attachment();
            if (buf.hasRemaining()) {
//                System.out.println("hasRemaining ... ");
                channel.write(buf);
            } else {
//                System.out.println("!hasRemaining ... gaga ");
                key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
//                channel.register(selector, SelectionKey.OP_READ);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void register(SocketChannel channel) throws ClosedChannelException {

        channel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(4096));
        selector.wakeup();

    }

}
