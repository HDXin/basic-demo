package top.atstudy.basic.nio;

import java.nio.ByteBuffer;

public class NioByteBufferTest {

    public static void main(String[] args) {

        //1、测试缓冲区
        testBuffer();

    }

    public static void testChannel(){


    }

    /**
     * test buffer
     *
     * 1、缓冲区（buffer）：在 Java NIO 中负责数据的存取。缓冲区就是数组。
     * 根据数据类型不同，提供了不同类型的buffer
     *
     * CharBuffer
     * ByteBuffer
     * ShortBuffer
     * IntBuffer
     * LongBuffer
     * FloatBuffer
     * DoubleBuffer
     *
     * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
     *
     * 2、缓冲区存取数据的两个核心方法
     * put(): 存入数据到缓存区
     * get(): 获取缓冲区的数据
     *
     * 3、缓存区中的四个核心属性
     * mark;
     * capacity：容量，表示缓存区中最大存储数据的容量。一旦声明不能被修改;
     * limit：界限，表示缓冲区中可以操作数据的大小。（limit以后的数据不能进行读写）;
     * position：位置，表示缓冲区中正在操作数据的位置;
     */
    public static void testBuffer(){

        // 1、分配一个指定大小的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("================== init =================");
        System.out.println(" ==>> capacity: " + buffer.capacity());
        System.out.println(" ==>> limit:    " + buffer.limit());
        System.out.println(" ==>> position: " + buffer.position());
        System.out.println(" ==>> mark:     " + buffer.mark());

        // 2、利用put存入数据到缓存区
        String str = "abc";
        buffer.put(str.getBytes());
        System.out.println("=================== put ================");
        System.out.println(" ==>> capacity: " + buffer.capacity());
        System.out.println(" ==>> limit:    " + buffer.limit());
        System.out.println(" ==>> position: " + buffer.position());
        System.out.println(" ==>> mark:     " + buffer.mark());

        // 3、切换到读取数据的模式
        buffer.flip();
        System.out.println("================= after flip ==================");
        System.out.println(" ==>> capacity: " + buffer.capacity());
        System.out.println(" ==>> limit:    " + buffer.limit());
        System.out.println(" ==>> position: " + buffer.position());
        System.out.println(" ==>> mark:     " + buffer.mark());

        // 4、读取缓冲区的数据
        byte[] b = new byte[buffer.limit()];
        buffer.get(b);
        System.out.println("================ get ===================");
        System.out.println(" ==>> get: " + new String(b));

        System.out.println("================= after get ==================");
        System.out.println(" ==>> capacity: " + buffer.capacity());
        System.out.println(" ==>> limit:    " + buffer.limit());
        System.out.println(" ==>> position: " + buffer.position());
        System.out.println(" ==>> mark:     " + buffer.mark());

        // 5、可重复读
        buffer.rewind();

        System.out.println("=============== after rewind ====================");
        System.out.println(" ==>> capacity: " + buffer.capacity());
        System.out.println(" ==>> limit:    " + buffer.limit());
        System.out.println(" ==>> position: " + buffer.position());
        System.out.println(" ==>> mark:     " + buffer.mark());

    }

}
