package top.atstudy.basic.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 创建 boosGroup 和 workerGroup
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
                    .childHandler(new ChannelInitializer<SocketChannel>() { //创建一个通道测试对象（匿名对象）
                        //给 pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    }); // 给我们的 workerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println(" ... 服务器 is ready ... ");

            //绑定一个端口并且同步， 生成一个 ChannelFuture 对象
            ChannelFuture cf = bootstrap.bind(8888).sync();

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();

        }finally {

            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }

    }

}
