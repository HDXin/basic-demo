package top.atstudy.basic.netty.nio.buffer;

import java.nio.IntBuffer;
import java.util.Random;

/**
 * int mark = -1;
 * int position = 0;
 * int limit;
 * int capacity;
 */
public class BufferTest {

    public static void main(String[] args) {

        IntBuffer buf = IntBuffer.allocate(8);

        System.out.println(" ====>> put2 ");
        for (int i = 0; i < buf.capacity() - 3; i++) {
            buf.put(new Random().nextInt(10));
        }

        buf.flip();
        System.out.println(" ====>> get2 ");
        for (int i = 0; i < buf.limit(); i++) {
            System.out.println(buf.get(i));
        }

        System.out.println(" ====>> put5 ");
        buf.flip();
        buf.put(new Random().nextInt(100));

        buf.flip();
        System.out.println(" ====>> get5 ");
        for (int i = 0; i < buf.limit(); i++) {
            System.out.println(buf.get(i));
        }

    }

}
