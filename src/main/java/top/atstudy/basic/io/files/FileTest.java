package top.atstudy.basic.io.files;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {

        File file = new File("F://temp/test.txt");

        if(file.isDirectory()){
            System.out.println(file.list());
        }else{
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
        }
    }

}
