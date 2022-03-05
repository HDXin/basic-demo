package top.atstudy.basic.netty.bio;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流
 * 3、释放资源
 */
@Slf4j
public class BioClientTest {

    private static AtomicInteger account = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("客户端启动了 ... ");

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            if (StrUtil.isNotBlank(data) && data.startsWith("x:")) {
                String num = StrUtil.sub(data, 2, data.length()).trim();

                creatConnection(newCachedThreadPool, Integer.parseInt(num));
            }

        }

    }


    public static void creatConnection(ExecutorService newCachedThreadPool, Integer num) {
        System.out.println("account: " + account.addAndGet(num));

        int account = 0;
        while (account < num) {
            account++;

            newCachedThreadPool.execute(() -> {
                try {
                    // 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
                    Socket socket = new Socket("localhost", 6666);

                    //2、操作：输入输出流
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

//                    Scanner scanner = new Scanner(System.in);
//                    while (scanner.hasNext()) {
//                        String data = scanner.nextLine();
//                        dos.writeUTF(data);
//                    }

                    try {
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 3、释放资源
                    dos.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
