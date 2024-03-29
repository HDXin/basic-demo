package top.atstudy.basic.netty.netty.websocket;

import cn.hutool.json.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这里 TextWebSocketFrame 类型，表示一个文本帧（frame）
 */
@Slf4j
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Channel channel = null;

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//
//        if (null != msg && msg instanceof FullHttpRequest) {
//            System.out.println(" get token ... ");
//            FullHttpRequest request = (FullHttpRequest) msg;
//
//            String uri = request.uri();
//            String origin = request.headers().get("Origin");
//            String auth = request.headers().get("auth");
//
//            System.out.println(" ==>> " + uri + ", " + origin + ", " + auth);
//            if (origin == null) {
////                ctx.close();
//            } else {
//                if (uri == null && uri.contains("/ws") && uri.contains("?")) {
//                    String[] uriArray = uri.split("\\?");
//                    if (null != uriArray && uriArray.length > 1) {
//                        String[] paramArray = uriArray[1].split("=");
//                        if (null != paramArray && paramArray.length > 1) {
//                            String token = paramArray[1];
//                            log.info(" token: {}", token);
//                        }
//                    }
//                    request.setUri("/ws");
//                }
//            }
//        }
//
//        super.channelRead(ctx, msg);
//    }

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

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive：" + ctx);


        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channelInactive：" + ctx);

        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        ctx.flush();

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
        System.out.println("handlerRemoved 被调用：" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("异常发生" + cause.getMessage());
        ctx.close();

    }


}
