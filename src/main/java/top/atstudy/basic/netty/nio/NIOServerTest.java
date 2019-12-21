package top.atstudy.basic.netty.nio;

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

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        ssChannel.bind(new InetSocketAddress(6666));

        ssChannel.configureBlocking(false);

        Selector selector = Selector.open();

        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){

            if(selector.select(1000) == 0){
                System.out.println("服务器已经等待了1秒， 无连接 ... ");
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()){

                SelectionKey key = keyIterator.next();

                if(key.isAcceptable()){
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);

                    sChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if(key.isReadable()){

                    SocketChannel sChannel = (SocketChannel) key.channel();

                    ByteBuffer buf = (ByteBuffer) key.attachment();
                    sChannel.read(buf);

                    System.out.println(" ===>>" + new String(buf.array()));
                }

                keyIterator.remove();
            }


        }

    }

}
