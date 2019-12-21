package top.atstudy.basic.io.net.udp.sendreceive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1、使用DatagramSocket 指定应用使用端口
 * 2、准备数据，一定转成字节数组
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {

        System.out.println("client 启动中 ... ");

        //1、使用DatagramSocket 指定应用使用端口
        DatagramSocket client = new DatagramSocket(6666);

        //2、准备数据，一定转成字节数组
        String data = "atstudy";
        byte[] datas = data.getBytes();

        //3、封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));

        //4、发送包裹send(DatagramPacket p)
        client.send(packet);

        //5、释放资源
        client.close();

    }

}
