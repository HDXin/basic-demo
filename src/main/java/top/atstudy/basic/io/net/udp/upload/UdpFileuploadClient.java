package top.atstudy.basic.io.net.udp.upload;

import java.io.*;
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
public class UdpFileuploadClient {

    public static void main(String[] args) throws IOException {

        System.out.println("client 启动中 ... ");

        //1、使用DatagramSocket 指定应用使用端口
        DatagramSocket client = new DatagramSocket(8888);

        //2、准备数据，一定转成字节数组
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F://temp/test.txt"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024*1024];
        int len = 0;
        while ((len = bis.read(b)) != -1){
            bos.write(b, 0, len);
        }
        byte[] datas = bos.toByteArray();

        //3、封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));

        //4、发送包裹send(DatagramPacket p)
        client.send(packet);

        //5、释放资源
        client.close();

    }

}
