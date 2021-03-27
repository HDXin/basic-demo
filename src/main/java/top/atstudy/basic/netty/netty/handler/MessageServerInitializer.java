package top.atstudy.basic.netty.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * 说明
 * 1、我们自定义的一个 Handler 需要继承 netty 规定好的某个 HandlerAdapter
 * 2、这时我们自定义的一个 Handler, 才能称为一个 Handler
 */
public class MessageServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        // 得到管道
        ChannelPipeline pipeline = ch.pipeline();

        System.out.println("===>> pipeline:" + pipeline.hashCode());

        // 加入一个netty提供的ServerCodec codec => [coder - decoder]
        pipeline.addLast(new MyByteToLongDecoder());

        // 2、添加一个自定义的 handler
        pipeline.addLast(new MessageServerHandler());

        System.out.println(" ok ~~~ ");

    }
}
