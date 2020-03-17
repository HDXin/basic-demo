package top.atstudy.basic.io.files;

import java.io.*;

public class StreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        demo01();

//        demo02();

//        demo03();

//        demo04();

//        demo05();

//        demo06();

//        demo07();

//        demo08();

//        demo09();

//        demo10();

        demo11();

    }

    /**
     * 字节：输入流
     * @throws IOException
     */
    private static void demo01() throws IOException {

        FileInputStream fis = new FileInputStream("F://temp/test.txt");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] b = new byte[1024*3];
        int len = 0;
        if((len = fis.read(b)) != -1){
            bos.write(b, 0, len);
        }

        fis.close();
        bos.close();

    }

    /**
     * 字节：输出流
     * @throws IOException
     */
    private static void demo02() throws IOException {

        FileInputStream fis = new FileInputStream("F://temp/test.txt");

        FileOutputStream fos = new FileOutputStream("F://temp/demo.txt");

        int len = 0;
        byte[] b = new byte[11];
        while ((len = fis.read(b)) != -1){
            fos.write(b, 0, len);
        }

        fis.close();
        fos.close();
    }

    /**
     * 字节：缓冲流
     * @throws IOException
     */
    private static void demo03() throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F://temp/11.jpeg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("f://temp/33.jpeg"));

        int len = 0;
        byte[] b = new byte[1024];
        while ((len = bis.read(b)) != -1){
            bos.write(b, 0, len);
        }

        bis.close();
        bos.close();
    }

    /**
     * 字符流
     * @throws IOException
     */
    private static void demo04() throws IOException {

        FileReader fr  = new FileReader("F://temp/test.txt");
        FileWriter fw = new FileWriter("F://temp/demo.txt");

        int len = 0;
        char[] c = new char[5];

        while ((len = fr.read(c)) != -1){
            fw.write(c, 0, len);
        }

        fr.close();
        fw.close();

    }

    /**
     * 字符缓冲流
     * @throws IOException
     */
    private static void demo05() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("F://temp/test.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F://temp/demo.txt"));

        int len = 0;
        char[] c = new char[11];
        while ((len = br.read(c)) != -1){
            bw.write(c, 0, len);
        }
        br.close();
        bw.close();
    }

    /**
     * 对象输输出流
     * @throws IOException
     */
    private static void demo06() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F://temp/person.txt"));
        oos.writeObject(new Person("Jerry", "15890908989", 25));

        oos.close();

    }

    /**
     * 对象输入流
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void demo07() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F://temp/person.txt"));
        Person person = (Person) ois.readObject();

        System.out.println(" ===>> person: " + person.toString());
    }



    /**
     * PrintStream(OutputStream out) 的测试函数
     *
     * 函数的作用，就是将字母“abcde”写入到文件“file.txt”中
     */
    private static void demo08() {
        // 0x61对应ASCII码的字母'a'，0x62对应ASCII码的字母'b', ...
        final byte[] arr={0x61, 0x62, 0x63, 0x64, 0x65 }; // abced
        try {
            // 创建文件“file.txt”的File对象
            File file = new File("file.txt");
            // 创建文件对应FileOutputStream
            PrintStream out = new PrintStream(
                    new FileOutputStream(file));
            // 将“字节数组arr”全部写入到输出流中
            out.write(arr);
            // 关闭输出流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * PrintStream(File file) 的测试函数
     *
     * 函数的作用，就是将字母“abcde”写入到文件“file.txt”中
     */
    private static void demo09() {
        final byte[] arr={0x61, 0x62, 0x63, 0x64, 0x65 };
        try {
            File file = new File("file.txt");
            PrintStream out = new PrintStream(file);
            out.write(arr);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * PrintStream(String fileName) 的测试函数
     *
     * 函数的作用，就是将字母“abcde”写入到文件“file.txt”中
     */
    private static void demo10() {
        final byte[] arr={0x61, 0x62, 0x63, 0x64, 0x65 };
        try {
            PrintStream out = new PrintStream("file.txt");
            out.write(arr);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试write(), print(), println(), printf()等接口。
     */
    private static void demo11() {
        // 0x61对应ASCII码的字母'a'，0x62对应ASCII码的字母'b', ...
        final byte[] arr={0x61, 0x62, 0x63, 0x64, 0x65 }; // abced
        try {
            // 创建文件对应FileOutputStream
//            PrintStream out = new PrintStream("other.txt");
            PrintStream out = new PrintStream(System.out);

            PrintStream ps = System.out;

            // 将字符串“hello PrintStream”+回车符，写入到输出流中
            out.println("hello PrintStream");
            // 将0x41写入到输出流中
            // 0x41对应ASCII码的字母'A'，也就是写入字符'A'
            out.write(0x41);
            // 将字符串"65"写入到输出流中。
            // out.print(0x41); 等价于 out.write(String.valueOf(0x41));
            out.print(0x41);
            // 将字符'B'追加到输出流中
            out.append('B');

            // 将"CDE is 5" + 回车  写入到输出流中
            String str = "CDE";
            int num = 5;
            out.printf("%s is %d\n", str, num);

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
