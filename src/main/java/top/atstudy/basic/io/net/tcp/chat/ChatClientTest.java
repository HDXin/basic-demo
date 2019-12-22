package top.atstudy.basic.io.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流
 * 3、释放资源
 */
public class ChatClientTest {

    public static void main(String[] args) throws IOException {
        System.out.println(" ===>> client start ... ");

        // 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket socket = new Socket("localhost", 8888);

        //2、操作：输入输出流
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            dos.writeUTF(data);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());
        }

        // 3、释放资源
        dos.close();
        socket.close();

    }

}
