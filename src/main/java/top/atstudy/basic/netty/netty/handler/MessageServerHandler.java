package top.atstudy.basic.netty.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 说明
 * <p>
 */
public class MessageServerHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {

        System.out.println("从客户端" + ctx.channel().remoteAddress() + "读取到Long " + msg);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {




    }
}
