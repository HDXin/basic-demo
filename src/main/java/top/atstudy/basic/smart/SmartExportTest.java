package top.atstudy.basic.smart;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/27 15:22
 * @Desc:
 */
@Slf4j
public class SmartExportTest {

    public static void main(String[] args) throws IOException {

        // 回执单处理
//        testRecord();

        // 承揽协议
        testProtocol();

        System.out.println("complate");


    }

    private static void testRecord() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\电子回单.csv"));

        List<AttachVO> list = new ArrayList<>(200000);
        String str = null;
        while ((str = br.readLine()) != null) {
            AttachVO vo = new AttachVO(str);
            list.add(vo);
        }


        for (AttachVO item : list) {
            System.out.println(item);
            System.out.println(item.getFileName());
        }
        System.out.println(list.size());


        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService taskExecutor = Executors.newScheduledThreadPool(200);

        for (AttachVO item : list) {
            if (StrUtil.isBlank(item.getMonth()) || StrUtil.isBlank(item.getRecordUrl())) {
                System.out.println(item);
                continue;
            }
            taskExecutor.execute(() -> testRequest(item.getRecordUrl(), item.getFilePath(), item));
        }


    }

    private static void testProtocol() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\承揽协议-线下.csv"));

        List<SelfVO> list = new ArrayList<>(200000);
        String str = null;
        while ((str = br.readLine()) != null) {
            SelfVO vo = new SelfVO(str);
            list.add(vo);
        }


        for (SelfVO item : list) {
            System.out.println(item);
            System.out.println(item.getFileName());
        }
        System.out.println(list.size());

        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService taskExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 5);

        for (SelfVO item : list) {
            taskExecutor.execute(() -> testRequest2(item.getRecordUrl(), item.getFilePath(), item));
        }


    }


    /**
     * @param url
     */
    private static void testRequest(String url, String filePath, AttachVO item) {
        File file = new File(filePath);
        if (file.exists()) {
            return;
        }


        HttpRequest request = HttpUtil.createGet(url);
        HttpResponse response = request.execute();
        System.out.println(" ===>> " + url);

        if (Integer.valueOf(302).equals(response.getStatus())) {
            String newUrl = response.header("Location");
            System.out.println(newUrl);

            testRequest(newUrl, filePath, item);
        } else {
            byte[] b = response.bodyBytes();
            try {
                FileOutputStream fos = new FileOutputStream(file);

                fos.write(b);
                fos.close();

                item.setExist(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param url
     */
    private static void testRequest2(String url, String filePath, SelfVO item) {
        File file = new File(filePath);
        if (file.exists()) {
            return;
        }


        HttpRequest request = HttpUtil.createGet(url);
        HttpResponse response = request.execute();
        System.out.println(" ===>> " + url);

        if (Integer.valueOf(302).equals(response.getStatus())) {
            String newUrl = response.header("Location");
            System.out.println(newUrl);

            testRequest2(newUrl, filePath, item);
        } else {
            byte[] b = response.bodyBytes();
            try {
                FileOutputStream fos = new FileOutputStream(file);

                fos.write(b);
                fos.close();

                item.setExist(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Data
    @ToString
    @AllArgsConstructor
    private static class AttachVO {

        private String id;

        private String userId;

        private String name;

        private String month;

        private String recordUrl;

        private Boolean exist = false;

        public AttachVO(String str) {
            String[] split = StrUtil.split(str, StrUtil.COMMA);
            this.id = split[0];
            this.month = split[1];
            this.recordUrl = split[2];
            this.userId = split[3];
            this.name = split[4];

            if (StrUtil.isBlank(this.month)) {
                File file = new File("E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\tt\\");
                if (!file.exists()) {
                    file.mkdir();
                }
                return;
            }

            // 创建目录
            File file = new File("E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\电子回单\\" + this.month);
            if (!file.exists()) {
                file.mkdir();
            }
        }

        private Boolean isMonth(String month) {
            if (StrUtil.isBlank(month)) {
                return StrUtil.isBlank(this.month);
            }
            return month.equals(this.month);
        }

        public String getFileName() {
            if (StrUtil.isBlank(this.recordUrl)) {
                return null;
            }

            String[] ss = StrUtil.split(this.recordUrl, StrUtil.DOT);
            return this.id + StrUtil.C_UNDERLINE + this.userId + StrUtil.C_UNDERLINE + this.name + StrUtil.DOT + ss[ss.length - 1];
        }

        public String getDir() {
            if (StrUtil.isBlank(this.month)) {
                return "E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\tt\\";
            }
            return "E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\电子回单\\" + this.month + "\\";
        }

        public String getFilePath() {
            if (StrUtil.isBlank(this.recordUrl)) {
                return null;
            }
            return this.getDir() + this.getFileName();
        }

    }



    @Data
    @ToString
    @AllArgsConstructor
    private static class SelfVO {

        private String userId;

        private String recordUrl;

        private Boolean exist = false;

        public SelfVO(String str) {
            String[] split = StrUtil.split(str, StrUtil.COMMA);
            this.userId = split[0];
            this.recordUrl = "https://goss.paat.com/public/preview/" + split[1];
        }

        public String getFileName() {
            if (StrUtil.isBlank(this.recordUrl)) {
                return null;
            }

            String[] ss = StrUtil.split(this.recordUrl, StrUtil.DOT);
            return this.userId + StrUtil.DOT + ss[ss.length - 1];
        }

        public String getDir() {
            return "E:\\temp\\2020.9-2021.8邦特\\2021.09数据导出\\承揽协议\\";
        }

        public String getFilePath() {
            if (StrUtil.isBlank(this.recordUrl)) {
                return null;
            }
            return this.getDir() + this.getFileName();
        }

    }


}
