package top.atstudy.basic.io.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、指定端口，使用 ServerSocket 创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */
public class ChatServerTest {

    public static void main(String[] args) throws IOException {

//        demo();

        demo2();

    }

    private static void demo2() throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println(" ===>> server start ... ");
        // 1、指定端口，使用 ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);

        while (true){
            // 2、阻塞式等待连接 accept
            Socket socket = server.accept();

            executorService.execute(() -> {
                try {
                    // 3、操作：输入输出流操作
                    String customer = Thread.currentThread().getName();
                    System.out.println(" 客户 " + customer + " 端建立了连接 ... ");

                    while (true){
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        String request = dis.readUTF();
                        System.out.println(" ==>> " + customer + ": " + request);

                        //            Scanner scanner = new Scanner(System.in);
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF("好的好的 ... ");
                        if(request != null && "exit".equals(request)){
                            System.out.println(" ==>> " + customer + " 已经下线... ");
                            dos.writeUTF("exit");
                            dis.close();
                            // 4、释放资源
                            socket.close();
                            break;
                        }else{
                            dos.writeUTF("好的好的 ... ");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


//        server.close();

        }

    }


    private static void demo() throws IOException {
        System.out.println(" ===>> server start ... ");

        // 1、指定端口，使用 ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);

        // 2、阻塞式等待连接 accept
        Socket socket = server.accept();

        // 3、操作：输入输出流操作
        System.out.println(" 一个客户端建立了连接 ... ");
        while (true){
            System.out.println(" ===>> ");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());

//            Scanner scanner = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("好的好的 ... ");
        }

        // 4、释放资源
//        dis.close();
//        socket.close();
//        server.close();
    }

}
