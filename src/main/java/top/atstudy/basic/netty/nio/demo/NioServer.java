package top.atstudy.basic.netty.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NioServer {

    public static void main(String[] args) throws IOException {
//        final LinkedList<SocketChannel> clients = new LinkedList<>();
//        final List<SocketChannel> clients = new ArrayList<>(50000);

        final Map<Integer, List<SocketChannel>> clientMap = new HashMap<>(5);
        clientMap.put(0, new ArrayList<SocketChannel>(50000));
        clientMap.put(1, new ArrayList<SocketChannel>(50000));
        clientMap.put(2, new ArrayList<SocketChannel>(50000));
        clientMap.put(3, new ArrayList<SocketChannel>(50000));
        clientMap.put(4, new ArrayList<SocketChannel>(50000));
        clientMap.put(5, new ArrayList<SocketChannel>(50000));
        clientMap.put(6, new ArrayList<SocketChannel>(50000));
        clientMap.put(7, new ArrayList<SocketChannel>(50000));
        clientMap.put(8, new ArrayList<SocketChannel>(50000));
        clientMap.put(9, new ArrayList<SocketChannel>(50000));

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(7788));
        ss.configureBlocking(false);

//        ss.setOption(StandardSocketOptions.TCP_NODELAY, false);


        new Thread(() -> {
//            System.out.println("-->>");
            while (true) {
//            System.out.println("..");


//                ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
//                synchronized (Object.class){
//                    for (SocketChannel c:clients){
//                        int num = 0;
//                        try {
//                            num = c.read(buffer);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                        if(num > 0){
//                            buffer.flip();
//                            byte[] b = new byte[buffer.limit()];
//                            buffer.get(b);
//
//                            String str = new String(b);
//                            if(StrUtil.isNotBlank(str)){
//                                System.out.println(c.socket().getPort() + " : " + str + "\n" + clients.size());
//                            }
//                            buffer.clear();
//                        }
//                    }
//                }
            }

        }).start();

        int index = 0;
        while (true) {
            SocketChannel client = ss.accept();
            if (client == null) {
                continue;
            }

            client.configureBlocking(false);

            index++;
            clientMap.get(index % 10).add(client);

            if (index % 1000 == 0) {
                System.out.println(" nums: " + index);
            }

        }

    }
}
