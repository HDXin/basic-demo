package top.atstudy.basic.netty.nio.basic.buffer;

import cn.hutool.core.util.RandomUtil;

import java.nio.IntBuffer;

/**
 * int mark = -1;
 * int position = 0;
 * int limit = 0;
 * int capacity ;
 */
public class BufferTest {

    private static IntBuffer buf;

    static {
        buf = IntBuffer.allocate(10);
    }

    public static void main(String[] args) {

        // test put
//        putTest();

        // test get
        getTest();

        // test get
//        getTest2();

        // test slice
//        sliceTest();

        // test duplicate
//        duplicateTest();

        // test compact
//        compactTest();

    }

    public static void compactTest() {

        putTest();
        buf.flip();

        for (int i = 0; i < 4; i++) {
            System.out.println(buf.get());
        }
        System.out.println(" ========= ");

        IntBuffer temp = buf.compact();
        while (temp.hasRemaining()) {
            System.out.println(temp.get());
        }

        System.out.println(" ==>> compact finish ... ");


    }

    /**
     * 复制一份
     */
    public static void duplicateTest() {

        putTest();
        buf.flip();

        for (int i = 0; i < 4; i++) {
            System.out.println(buf.get());
        }
        System.out.println(" ========= ");

        IntBuffer temp = buf.duplicate();
        while (temp.hasRemaining()) {
            System.out.println(temp.get());
        }

        System.out.println(" ==>> duplicate finish ... ");

    }

    /**
     * 截取剩余有效数据
     */
    public static void sliceTest() {
        putTest();
        buf.flip();

        for (int i = 0; i < 4; i++) {
            System.out.println(buf.get());
        }
        System.out.println(" ========= ");

        IntBuffer temp = buf.slice();
        while (temp.hasRemaining()) {
            System.out.println(temp.get());
        }

        System.out.println(" ==>> slice finish ... ");

    }

    public static void getTest2() {

        putTest();
        buf.flip();

        while (buf.hasRemaining()) {
            System.out.println(buf.get());
        }

        System.out.println(" ==>> get finish ... ");

    }

    public static void getTest() {

        putTest();
        buf.flip();

        for (int i = 0; i < buf.limit(); i++) {
            System.out.println(buf.get(i));
        }

        System.out.println(" ==>> get finish ... ");

    }

    public static void putTest() {

        for (int i = 0; i < buf.capacity() - 3; i++) {
            buf.put(RandomUtil.randomInt(10, 20));
        }

        System.out.println(" ==>> put finish ... ");

    }

}
