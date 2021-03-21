package top.atstudy.basic.netty.netty.httpserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 说明
 * 1、我们自定义的一个 Handler 需要继承 netty 规定好的某个 HandlerAdapter
 * 2、这时我们自定义的一个 Handler, 才能称为一个 Handler
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {


        // 向管道加入处理器


        // 得到管道
        ChannelPipeline pipeline = ch.pipeline();

        System.out.println("===>> pipeline:" + pipeline.hashCode());

        // 加入一个netty提供的HttpServerCodec codec => [coder - decoder]
        // HttpServerCodec 说明
        // 1、HttpServerCodec 是 netty 提供的处理 http 的 编 - 解码器
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());

        // 2、添加一个自定义的 handler
        pipeline.addLast("MyHttpServerHandler", new HttpServerHandler());

        System.out.println(" ok ~~~ ");

    }
}
