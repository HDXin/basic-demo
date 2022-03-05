package top.atstudy.basic.io.net.tcp.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);

        Socket socket = server.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F://temp/upload.jpeg"));
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }

        bis.close();
        bos.close();
        socket.close();


    }

}
