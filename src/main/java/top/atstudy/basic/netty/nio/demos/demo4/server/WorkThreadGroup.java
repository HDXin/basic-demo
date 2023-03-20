package top.atstudy.basic.netty.nio.demos.demo4.server;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class WorkThreadGroup {

    private List<WorkThread> workThreads;

    public WorkThreadGroup(){
        this(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public WorkThreadGroup(int size) {
        workThreads = new ArrayList<>(3);
        for (int i = 0; i < size; i++) {
            try {
                WorkThread workThread = new WorkThread();
                workThreads.add(workThread);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //
        for (int i = 0; i < size; i++) {
            new Thread(workThreads.get(i)).start();
        }
    }

    public void add(SocketChannel channel) {
        try {
            this.nextWorkThread().register(channel);
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }

    }

    private int index = 0;

    private synchronized WorkThread nextWorkThread() {
        int next = index % workThreads.size();
        index++;
//        System.out.println(Thread.currentThread().getName() + " index： " + next);
        return workThreads.get(next);
    }

}
