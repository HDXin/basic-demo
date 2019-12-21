package top.atstudy.basic.netty.nio;

import java.nio.IntBuffer;
import java.util.Random;

public class BufferTest {

    public static void main(String[] args) {

        IntBuffer buf = IntBuffer.allocate(8);


        System.out.println(" ====>> put ");
        for (int i = 0; i < buf.capacity() - 3; i++) {
            buf.put(new Random().nextInt(10));
        }

        buf.flip();
        System.out.println(" ====>> get ");
        for (int i = 0; i < buf.limit(); i++) {
            System.out.println(buf.get(i));
        }


    }

}
