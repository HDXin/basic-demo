package top.atstudy.basic.netty.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * 说明
 * 1、我们自定义的一个 Handler 需要继承 netty 规定好的某个 HandlerAdapter
 * 2、这时我们自定义的一个 Handler, 才能称为一个 Handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 读取数据（这里我们可以读取客户端发送的消息）
     * 1、ChannelHandlerContext ctx: 上下文对象， 含有管道 pipeline, 通道：channel, 地址
     * 2、Object msg: 就是客户端发送的数据 默认：Object
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" 服务器端线程： " + Thread.currentThread().getName());
        System.out.println(" ctx: " + ctx);

        //将msg转成一个 ByteBuf
        //ByteBuf 是 netty 提供的，不是 NIO 的 ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println(" 客户端： " + buf.toString(CharsetUtil.UTF_8));
        System.out.println(" 客户端地址： " + ctx.channel().remoteAddress());


        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello netty 客户端 111", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("ex: " + e);
                }
            }
        });

        ctx.channel().eventLoop().execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello netty 客户端 555", CharsetUtil.UTF_8));
            } catch (Exception e) {
                System.out.println("ex: " + e);
            }
        });

    }


    /**
     * 数据读取完毕
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        /**
         * writeAndFlush 是 write + flush
         * 将数据写入到缓存，并刷新
         * 一般讲，我们对这个发送的数据进行编码
         */
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello netty 客户端 222", CharsetUtil.UTF_8));
    }

    /**
     * 处理异常，一般是关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
