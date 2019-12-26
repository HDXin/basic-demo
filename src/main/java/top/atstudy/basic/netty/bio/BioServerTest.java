package top.atstudy.basic.netty.bio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 思路：
 * 1、创建一个线程池
 * 2、如果有客户端连接，就创建一个线程，与之通讯（单独写一个方法）
 */
public class BioServerTest {

    public static void main(String[] args) throws IOException {


        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了 ... ");

        while (true){

            Socket socket = serverSocket.accept();

            //就创建一个线程，与之通讯（单独写一个方法）
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });

        }

    }

    public static void handler(Socket socket){

        try {
            System.out.println("线程信息 ID:" + Thread.currentThread().getId() + ", name:" + Thread.currentThread().getName());
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            while (true){
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = bis.read(b)) != -1){
                    System.out.println(new String(b, 0, len));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭和Client连接");
            try{
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
