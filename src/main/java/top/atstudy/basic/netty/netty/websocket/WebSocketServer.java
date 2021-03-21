package top.atstudy.basic.netty.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServer {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 创建 bossGroup 和 workerGroup
         * 说明
         * 1、创建两个线程组 boosGroup 和 workerGroup
         * 2、bossGroup 只是处理连接请求，真正的和客户端业务处理，会交给 workerGroup 完成
         * 3、两个都是无限循环
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class) //使用 NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .handler(new LoggingHandler(LogLevel.INFO)) // 给我们的 bossGroup 的 EventLoop 对应的管道设置处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            ChannelPipeline pipeline = ch.pipeline();

                            // 因为基于 http 协议，使用http的编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            // 是以块的方式写，添加ChunkedWriteHandler处理器
                            pipeline.addLast(new ChunkedWriteHandler());

                            /**
                             * http数据在传输过程中是分段的
                             * HttpObjectAggregator 就是可以将多个段聚合起来
                             * 这就是为什么当浏览器发送大量数据时，就会发出多次http请求
                             */
                            pipeline.addLast(new HttpObjectAggregator(8192));

                            /**
                             * 1、对于 WebSocket，它的数据是以帧（frame）的形式传递
                             * 2、可以看出 WebSoecketFrame 下面有6个子类
                             * 3、浏览器发送请求时 ws://localhost:7000/xxx
                             * 4、WebSocketServerProtocolHandler 核心功能是将 http 协议升级为 ws 协议，保持长连接
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                            // 自定义handler，处理业务请求
                            pipeline.addLast(new MyTextWebSocketFrameHandler());

                        }
                    }); // 给我们的 workerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println(" ... 服务器 is ready ... ");

            //绑定一个端口并且同步， 生成一个 ChannelFuture 对象
            ChannelFuture cf = bootstrap.bind(7777).sync();


            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口 7777 成功");
                    } else {
                        System.out.println("监听端口 7777 失败");
                    }
                }
            });

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }

    }

}
