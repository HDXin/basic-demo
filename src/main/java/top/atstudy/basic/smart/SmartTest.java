package top.atstudy.basic.smart;

import cn.hutool.core.collection.CollUtil;
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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/27 15:22
 * @Desc:
 */
@Slf4j
public class SmartTest {

    public static void main(String[] args) throws IOException {

        // 身份证处理
//        testIdCard();

        // 回执单处理
        testRecord();

        System.out.println("complate");


    }

    private static void testRecord() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("E:\\temp\\images\\任务回执单_new.csv"));

        List<AttachVO> list = new ArrayList<>(200000);
        String str = null;
        while ((str = br.readLine()) != null) {
            AttachVO vo = new AttachVO(str);
            if (vo.isMonth("2020-11")) {
                list.add(vo);
            }
        }

        System.out.println("size: " + list.size());
        System.out.println("valid: " + list.stream().filter(e -> StrUtil.isNotBlank(e.getRecordUrl())).collect(Collectors.toList()).size());
        System.out.println("invalid: " + list.stream().filter(e -> StrUtil.isBlank(e.getRecordUrl())).collect(Collectors.toList()).size());

//        for (AttachVO item : list) {
//            System.out.println(item);
//            System.out.println(item.getFileName());
//        }
//        System.out.println(list.size());
//
//
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService taskExecutor = Executors.newScheduledThreadPool(200);
//
//        for (AttachVO item : list) {
//            if (StrUtil.isBlank(item.getMonth()) || StrUtil.isBlank(item.getRecordUrl())) {
//                System.out.println(item);
//                continue;
//            }
//            taskExecutor.execute(() -> testRequest(item.getRecordUrl(), item.getFilePath(), item));
//        }
//
//


    }


    private static void testIdCard() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("E:\\temp\\images\\已认证的身份证号.csv"));

        List<SelfEmployed> list = new ArrayList<>(100000);
        String str = null;
        while ((str = br.readLine()) != null) {
            List<SelfEmployed> s = SelfEmployed.parse(str);
            list.addAll(s);
        }

        for (SelfEmployed item : list) {
            System.out.println(item);
            System.out.println(item.getFileName());
        }
        System.out.println(list.size());

        ExecutorService taskExecutor = Executors.newScheduledThreadPool(20);

        for (SelfEmployed selfEmployed : list) {
            taskExecutor.execute(() -> testRequest(selfEmployed.getCardUrl(), "E:\\temp\\images\\idcard\\" + selfEmployed.getFileName(), null));
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

    @Data
    @ToString
    @AllArgsConstructor
    private static class SelfEmployed {

        private String userId;

        private String name;

        private String cardUrl;

        private Integer index;

        public SelfEmployed() {
        }

        public static List<SelfEmployed> parse(String str) {
            String[] split = StrUtil.split(str, StrUtil.COMMA);
            return Arrays.asList(new SelfEmployed(split[0], split[1], split[2], 1), new SelfEmployed(split[0], split[1], split[3], 2));
        }

        public String getFileName() {

            String[] ss = StrUtil.split(this.cardUrl, StrUtil.DOT);
//            System.out.println(ss[ss.length - 1]);

            return this.userId + StrUtil.C_UNDERLINE + this.name + StrUtil.C_UNDERLINE + this.index + StrUtil.DOT + ss[ss.length - 1];
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
                File file = new File("E:\\temp\\images\\record_new\\tt");
                if (!file.exists()) {
                    file.mkdir();
                }
                return;
            }

            // 创建目录
            File file = new File("E:\\temp\\images\\record_new\\" + this.month);
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
                return "E:\\temp\\images\\record_new\\tt\\";
            }
            return "E:\\temp\\images\\record_new\\" + this.month + "\\";
        }

        public String getFilePath() {
            if (StrUtil.isBlank(this.recordUrl)) {
                return null;
            }
            return this.getDir() + this.getFileName();
        }

    }

}
