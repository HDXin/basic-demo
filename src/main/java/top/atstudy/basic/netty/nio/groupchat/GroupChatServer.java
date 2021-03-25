package top.atstudy.basic.netty.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 8888;

    public GroupChatServer(){
        try {
            //得到选择器
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将该 listenChannel 注册到 selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //监听
    public void listen(){
        try {
            //循环处理
            while (true){
                int count = selector.select(2);
                if(count > 0){ //有时间处理
                    //遍历得到 SelectionKey 集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        //取出 selectionkey
                        SelectionKey key = iterator.next();
                        //监听到 accept
                        if(key.isAcceptable()){
                            SocketChannel sc = listenChannel.accept();
                            //设置为非阻塞
                            sc.configureBlocking(false);
                            //将该 sc 注册到 selector
                            sc.register(selector, SelectionKey.OP_READ);
                            //提示
                            System.out.println(sc.getRemoteAddress() + "上线");
                        }

                        if(key.isReadable()){ //通道发送 read 事件，即通道是可读状态
                            //处理读（专门写方法）
                            readData(key);
                        }

                        //当前的 key 删除，防止重复操作
                        iterator.remove();
                    }
                } else {
//                    System.out.println("等待 ... ");
                }

            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {

        }
    }

    //读取客户端消息
    private void readData(SelectionKey key){
        System.out.println(Thread.currentThread().getName());
        //获取关联的 channel
        SocketChannel channel = null;
        try {
            //得到关联的 channel
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            //根据 count 的值做处理
            if(count > 0){
                //把缓存区的数据转换成字符串
                String msg = new String(buffer.array());
                //输出消息
                System.out.println("form 客户端： " + msg);

                //向其它的客户端转发消息(去掉自己)， 专门写一个方法来处理
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e){
            try {
                System.out.println(channel.getRemoteAddress() + "离线了...");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException e2){
                e.printStackTrace();
            }
        }
    }

    //转发消息给其它客户（通道）
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {

        System.out.println("服务器转发消息中 ... ");
        //遍历 所有注册到 Selector 上的 SocketChannel, 并排除 self
        for(SelectionKey key:selector.keys()){
            //通过key 取出对应的 SocketChannel
            Channel targetChannel = key.channel();

            //排除自己
            if(targetChannel instanceof SocketChannel && targetChannel != self){
                //转型
                SocketChannel dest = (SocketChannel) targetChannel;
                //将 msg 存储到 buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());


                //将buffer的数据写入通道
                dest.write(buffer);
            }
        }
    }

    public static void main(String[] args) {

        //创建服务器对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }

}
