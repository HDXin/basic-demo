package top.atstudy.basic.io.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1、指定端口，使用 ServerSocket 创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */
public class ChatServerTest {

    public static void main(String[] args) throws IOException {
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
