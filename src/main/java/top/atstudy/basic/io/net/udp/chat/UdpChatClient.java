package top.atstudy.basic.io.net.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * 发送端
 * 1、使用DatagramSocket 指定应用使用端口
 * 2、准备数据，一定转成字节数组
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 */
public class UdpChatClient {

    public static void main(String[] args) throws IOException {

        System.out.println("client 启动中 ... ");

        //1、使用DatagramSocket 指定应用使用端口
        DatagramSocket client = new DatagramSocket(8888);

        //2、准备数据，一定转成字节数组
        Scanner scanner = new Scanner(System.in);
        byte[] datas = null;
        while (scanner.hasNext()){
            String msg = scanner.next();

            datas = msg.getBytes();

            //3、封装成DatagramPacket包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 7777));

            //4、发送包裹send(DatagramPacket p)
            client.send(packet);

        }


        //5、释放资源
        client.close();

    }

}
