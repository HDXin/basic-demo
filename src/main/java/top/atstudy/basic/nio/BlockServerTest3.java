package top.atstudy.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockServerTest3 {

    public static void main(String[] args) throws IOException {

        ExecutorService service = Executors.newCachedThreadPool();

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.bind(new InetSocketAddress(6666));

        while(true){
            final SocketChannel sChannel = ssChannel.accept();
            System.out.println(" ===>> 客户端请求连接");

            service.execute(() -> {
                try {
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(Thread.currentThread().getName() + " ==>> " + new String(buf.array(), 0, len));
                        buf.clear();
                    }

                    buf.put("服务器已成功接收到数据".getBytes());
                    buf.flip();
                    sChannel.write(buf);
                    sChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
//        ssChannel.close();
    }

}
