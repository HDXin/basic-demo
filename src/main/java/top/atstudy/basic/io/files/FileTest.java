package top.atstudy.basic.io.files;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.json.JSONObject;
import lombok.Data;
import lombok.ToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileTest {

    public static void main(String[] args) {

        // copy
//        copay();

        // zip
//        zip();

    }


    private static void zip(){
        File source = new File("E:\\temp\\images\\回单");
        File[] tempFile = source.listFiles();
        for (File file : tempFile) {
            String fileName = file.getName() + ".zip";
            System.out.println(file.getPath() + ", " + "E:\\temp\\images\\回单-ZIP\\" + fileName);
//            ZipUtil.zip(file.getPath(), "E:\\temp\\images\\回单-ZIP\\" + fileName, true);

            ExecutorService taskExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 5);
            taskExecutor.execute(() -> ZipUtil.zip(file.getPath(), "E:\\temp\\images\\回单-ZIP\\" + fileName, true));

        }
    }

    private static void copay(){

        ExecutorService taskExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 5);

        File files = new File("E:\\temp\\images\\任务电子回单");
        String basePath = "E:\\temp\\images\\回单\\";

        // 按月份获取
        File[] list = files.listFiles();

        List<AttachVO> attachs = new ArrayList<>(200000);
        for (File item : list) {
            int a = 0;
            File[] months = item.listFiles();
            String itemDir = item.getName() + "-0";
            System.out.println(item.getPath());
            for (int i = 0; i < months.length; i++) {
                if (i % 1000 == 0) {
                    a += 1;
                }
                String targetDir = basePath + itemDir + a;
                if (!new File(targetDir).exists()) {
                    new File(targetDir).mkdir();
                }
                String targetPath = targetDir + "\\" + months[i].getName();
                attachs.add(new AttachVO(months[i], targetPath));
            }
        }

        attachs.forEach(e -> System.out.println(e));


        attachs.forEach(e -> {
            taskExecutor.execute(() -> {
                try {
                    IoUtil.copy(new FileInputStream(e.getSource()), new FileOutputStream(new File(e.getTarget())), 1024 * 1024);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });
        });
    }

    @Data
    @ToString
    static class AttachVO {

        private File source;

        private String target;

        public AttachVO(File file, String target) {
            this.source = file;
            this.target = target;
        }
    }

}
