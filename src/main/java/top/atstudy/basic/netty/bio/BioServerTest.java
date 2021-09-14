package top.atstudy.basic.netty.bio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 思路：
 * 1、创建一个线程池
 * 2、如果有客户端连接，就创建一个线程，与之通讯（单独写一个方法）
 */
public class BioServerTest {

    private static AtomicInteger account = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {


        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了 ... ");

        while (true) {

            Socket socket = serverSocket.accept();

            //就创建一个线程，与之通讯（单独写一个方法）
            newCachedThreadPool.execute(() -> handler(socket));

        }

    }

    public static void handler(Socket socket) {

        try {
            System.out.println("account: " + account.addAndGet(1) + ", 线程信息 ID:" + Thread.currentThread().getId() + ", name:" + Thread.currentThread().getName());
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            while (true) {
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = bis.read(b)) != -1) {
                    System.out.println(new String(b, 0, len));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("account: " + account.addAndGet(-1) + ", 线程关闭了 ID: " + Thread.currentThread().getId());
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
