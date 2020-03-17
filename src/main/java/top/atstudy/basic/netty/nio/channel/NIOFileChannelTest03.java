package top.atstudy.basic.netty.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannelTest03 {

    public static void main(String[] args) throws IOException {

        //
//        copy02();

        //内存中修改
//        readerWriter();



    }


    private static void demo(){



    }

    /**
     * 文件在内存中修改
     * @throws IOException
     */
    public static void readerWriter() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("F://temp/test.txt", "rw");

        FileChannel fileChannel = raf.getChannel();

        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 20);
        buffer.put(0, (byte)'T');
        buffer.put(2, (byte)'0');
        buffer.put(10, (byte)'Y');
        System.out.println("修改成功...");

        raf.close();
        fileChannel.close();
    }

    public static void copy02() throws IOException {

        FileInputStream fis = new FileInputStream("F://temp/11.jpeg");
        FileChannel inChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("F://temp/99.jpeg");
        FileChannel outChannel = fos.getChannel();


        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
        fis.close();
        fos.close();

    }

    /**
     * channel buffer 拷贝
     * @throws IOException
     */
    public static void test01() throws IOException {
        //创建一个输入流 buffer
        FileInputStream fis = new FileInputStream("F://temp/11.jpeg");
        FileChannel inChannel = fis.getChannel();

        //创建一个输出流 buffer
        FileOutputStream fos = new FileOutputStream("F://temp/55.jpeg");
        FileChannel outChanell = fos.getChannel();

        //创建一个缓存区
        ByteBuffer buf = ByteBuffer.allocate(1);
        while (inChannel.read(buf) != -1){
            buf.flip();
            outChanell.write(buf);

            buf.clear();
        }
        outChanell.close();
        inChannel.close();
        fis.close();
        fos.close();
    }
}
