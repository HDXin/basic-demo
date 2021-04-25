package top.atstudy.basic.netty.netty.websocket;

import cn.hutool.json.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.camel.util.json.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这里 TextWebSocketFrame 类型，表示一个文本帧（frame）
 */
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        System.out.println("服务器收到消息：" + msg.text());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        new MessageVO(sdf.format(new Date()), msg.text());

        JSONObject obj = new JSONObject();
        obj.append("msg", msg.text());
        obj.append("date", sdf.format(new Date()));
        ctx.channel().writeAndFlush(new TextWebSocketFrame(obj.toString()));

    }

    /**
     * 当web客户端连接后，触发方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        // id 表示唯一的值，LongText 是唯一的 ShortText 不是唯一
        System.out.println("handlerAdded 被调用：" + ctx.channel().id().asLongText());
        System.out.println("handlerAdded 被调用：" + ctx.channel().id().asShortText());

        channelGroup.add(ctx.channel());

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved 被调用" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("异常发生" + cause.getMessage());
        ctx.close();

    }
}
