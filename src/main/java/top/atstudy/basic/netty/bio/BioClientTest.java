package top.atstudy.basic.netty.bio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流
 * 3、释放资源
 */
public class BioClientTest {

    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动了 ... ");

        // 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket socket = new Socket("localhost", 6666);

        //2、操作：输入输出流
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            dos.writeUTF(data);
        }

        // 3、释放资源
        dos.close();
        socket.close();
    }

}
