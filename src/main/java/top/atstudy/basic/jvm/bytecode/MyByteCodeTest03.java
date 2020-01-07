package top.atstudy.basic.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

public class MyByteCodeTest03 {

    public static void main(String[] args) {

        try {

            InputStream is = new FileInputStream("test.txt");

            ServerSocket socket = new ServerSocket(9999);
            socket.accept();

        } catch (FileNotFoundException ex){

        } catch (IOException ex){

        } catch (Exception ex){

        } finally {
            System.out.println("finally");
        }

    }

}
