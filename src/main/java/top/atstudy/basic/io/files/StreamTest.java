package top.atstudy.basic.io.files;

import java.io.*;

public class StreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        inputStreamTest();

//        outputStreamTest();

//        test03();

//        test04();

//        test05();

//        test06();

        test07();

    }

    private static void inputStreamTest() throws IOException {


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

    private static void outputStreamTest() throws IOException {

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

    private static void test03() throws IOException {

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

    private static void test04() throws IOException {

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

    private static void test05() throws IOException {

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
     * 对象输出流
     * @throws IOException
     */
    private static void test06() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F://temp/person.txt"));
        oos.writeObject(new Person("Jerry", "15890908989", 25));

        oos.close();

    }

    private static void test07() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F://temp/person.txt"));
        Person person = (Person) ois.readObject();

        System.out.println(" ===>> person: " + person.toString());
    }

}
