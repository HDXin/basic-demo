package top.atstudy.basic.netty.nio.demos.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;

public class SelectorThreadGroup {

    private Integer nums;

    SelectorThread[] sts;

    public SelectorThreadGroup(Integer nums){

        sts = new SelectorThread[nums];
        for (int i = 0; i < nums; i++) {
            sts[i] = new SelectorThread();

            new Thread(sts[i]).start();
        }

    }

    public void bind(Integer port){

        try {
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            ssChannel.configureBlocking(false);
            ssChannel.bind(new InetSocketAddress(port));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private void nextSelector(Channel channel){


    }

}
