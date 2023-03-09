package top.atstudy.basic.netty.nio.demo;

import cn.hutool.core.util.StrUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class NioServer {

    public static void main(String[] args) throws IOException {
        final LinkedList<SocketChannel> clients = new LinkedList<>();
//        final ConcurrentHashMap<Integer, SocketChannel> clientMap = new ConcurrentHashMap<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(7788));
//        ss.configureBlocking(true);
        ss.configureBlocking(false);

//        ss.setOption(StandardSocketOptions.TCP_NODELAY, false);


        new Thread(() -> {
//            System.out.println("-->>");
            while (true){
//            System.out.println("..");
                ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
                synchronized (Object.class){
                    for (SocketChannel c:clients){
                        int num = 0;
                        try {
                            num = c.read(buffer);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if(num > 0){
                            buffer.flip();
                            byte[] b = new byte[buffer.limit()];
                            buffer.get(b);

                            String str = new String(b);
                            if(StrUtil.isNotBlank(str)){
                                System.out.println(c.socket().getPort() + " : " + str + "\n" + clients.size());
                            }
                            buffer.clear();
                        }
                    }

                }
            }

        }).start();

        while (true){

            SocketChannel client = ss.accept();
            if(client == null){
//                System.out.println(" -->> null");
            }else{
                client.configureBlocking(false);
                int port = client.socket().getPort();
                if(clients.size() % 100 == 0){
                    System.out.println("c num " + clients.size());
                }
//                System.out.println("client port: " + port);
                synchronized (Object.class){
                    clients.add(client);
                }
            }


        }

    }
}
