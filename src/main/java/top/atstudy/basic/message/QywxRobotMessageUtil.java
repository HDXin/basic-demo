package top.atstudy.basic.message;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QywxRobotMessageUtil {

    private static final String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=%s";

    private static final String DEFAULT_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=a68b1c64-56a0-4129-81da-3e645865deeb";

    private static ExecutorService taskExecutor = null;

    static {
        taskExecutor = ExecutorBuilder.create().setCorePoolSize(Runtime.getRuntime().availableProcessors()).build();
    }

    public static void send(AbstractQywxRobotMessage msg) {
        taskExecutor.execute(() -> {
            String resp = HttpUtil.post(StrUtil.isNotBlank(msg.getApiUrl()) ? msg.getApiUrl() : DEFAULT_URL, msg.toBodyText());
            log.info("==>> resp: {}", resp);
        });
    }

    public static void send(String key, String text) {
        taskExecutor.execute(() -> {
            String resp = HttpUtil.post(String.format(BASE_URL, key), text);
            log.info("==>> resp: {}", resp);
        });
    }

    public static void send(String text) {
        taskExecutor.execute(() -> {
            String resp = HttpUtil.post(DEFAULT_URL, text);
            log.info("==>> resp: {}", resp);
        });
    }

    /**
     * {
     * "msgtype": "text",
     * "text": {
     * "content": "广州今日天气：29度，大部分多云，降雨概率：60%",
     * "mentioned_list":["wangqing","@all"],
     * "mentioned_mobile_list":["13800001111","@all"]
     * }
     * }
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        String api = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=a68b1c64-56a0-4129-81da-3e645865deeb";

        Map<String, Object> contentMap = new HashMap<>();
        contentMap.put("content", "test");
//        contentMap.put("mentioned_list", Arrays.asList("Huangdexin"));
        contentMap.put("mentioned_mobile_list", Arrays.asList("18737670736"));

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("msgtype", "text");
        paramMap.put("text", contentMap);

        String param = JSONUtil.toJsonStr(paramMap);
        System.out.println(param);


        QywxRobotMessageUtil.send(param);

        TimeUnit.SECONDS.sleep(10);
    }

}
