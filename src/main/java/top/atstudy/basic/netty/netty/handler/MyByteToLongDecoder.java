package top.atstudy.basic.netty.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyByteToLongDecoder extends ByteToMessageDecoder {

    /**
     * @param ctx 上下文对象
     * @param in  入栈的 ByteBuf
     * @param out List 集合，将解码后的数据传给下一个Handler
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder encode 被调用");
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }

    }
}
