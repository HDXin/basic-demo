package top.atstudy.basic.netty.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MessageClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        // 获取到管道
        ChannelPipeline pipeline = ch.pipeline();
        System.out.println("===>> pipeline:" + pipeline.hashCode());

        // 加入一个netty提供的ServerCodec codec => [coder - decoder]
        pipeline.addLast(new MyLongToByteEncoder());

        // 2、添加一个自定义的 handler
        pipeline.addLast(new MessageClientHandler());

        System.out.println(" ok ~~~ ");


    }
}
