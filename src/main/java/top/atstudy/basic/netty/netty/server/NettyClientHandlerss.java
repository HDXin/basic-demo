package top.atstudy.basic.netty.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandlerss extends ChannelInboundHandlerAdapter {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端： " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello server, 跟我一起学猫叫", CharsetUtil.UTF_8));
    }

    /**
     * 当通道准备就绪就会触发该方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端： " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("通道已经准备就绪", CharsetUtil.UTF_8));
    }

    /**
     * 当通道有读取事件时，会触发
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务器回复消息： " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器地址： " + ctx.channel().remoteAddress());
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
