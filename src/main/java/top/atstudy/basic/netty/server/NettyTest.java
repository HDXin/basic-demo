package top.atstudy.basic.netty.server;

import io.netty.util.NettyRuntime;

public class NettyTest {

    public static void main(String[] args) {
//        int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        int DEFAULT_EVENT_LOOP_THREADS = NettyRuntime.availableProcessors();

        System.out.println(" ===>> " + DEFAULT_EVENT_LOOP_THREADS);



    }
}
