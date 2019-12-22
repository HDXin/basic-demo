package top.atstudy.basic.io.net.tcp.upload;

import java.io.*;
import java.net.Socket;

public class UploadClientTest {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9999);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F://temp/11.jpeg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = bis.read(b)) != -1){
            bos.write(b, 0, len);
        }
        bos.close();
        bis.close();
    }


}
