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

    private static ExecutorService taskExecutor = Executors.newCachedThreadPool();

    private static AtomicInteger accounts = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动了 ... ");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            if(StrUtil.isNotBlank(data) && StrUtil.startWith(data, "x:")){
                String num = StrUtil.sub(data, 2, data.length()).trim();
                createConnection(Integer.parseInt(num));
            }

        }

    }

    public static void createConnection(Integer num) {
        System.out.println("account: " + accounts.addAndGet(num));

        if (num == null) {
            return;
        }

        int index = 0;
        while (index < num) {
            index++;
            taskExecutor.execute(() -> {
                try {
                    // 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
                    Socket socket = new Socket("localhost", 6666);

                    //2、操作：输入输出流
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.write("hello, tcp".getBytes());

                    TimeUnit.SECONDS.sleep(1000);

                    // 3、释放资源
                    dos.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }


    }

}
