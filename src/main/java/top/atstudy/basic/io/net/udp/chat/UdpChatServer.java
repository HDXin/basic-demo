package top.atstudy.basic.io.net.udp.chat;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1、使用DatagramSocket 指定应用使用端口
 * 2、准备容器封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据
 * byte[] getData()
 *        getLength();
 * 5、释放资源
 */
public class UdpChatServer implements Runnable{

    public static void main(String[] args) throws IOException {
        System.out.println(" server 启动 ... ");

        // 1、使用DatagramSocket 指定应用使用端口
        DatagramSocket server = new DatagramSocket(7777);

        // 2、准备容器封装成DatagramPacket包裹
        byte[] content = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(content, 0, content.length);

        // 3、阻塞式接收包裹receive(DatagramPacket p)
        server.receive(packet);

        // 4、分析数据
        // byte[] getData()
        //        getLength();
        byte[] receive = packet.getData();
        System.out.println(new String(receive, 0, receive.length));

        // 5、释放资源
        server.close();

    }

    @Override
    public void run() {

    }
}
