package top.atstudy.basic.smart;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/27 15:22
 * @Desc:
 */
@Slf4j
public class SmartTest {

    public static void main(String[] args) {

//        HttpRequest request = HttpUtil.createGet("https://pop.hp.dev.sudaotech.com/api/consumer/orderservice/products/search?sellerId=104&offset=0&limit=8");
//        HttpResponse response = request.execute();
//        System.out.println(" ===>> \n" + response.body());

        testRequest(10000);

    }

    /**
     *
     * @param total
     */
    private static void testRequest(Integer total){
        final String url = "https://pop.hp.dev.sudaotech.com/api/consumer/orderservice/products/36863987000005?sellerId=104";
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < total; i++) {
            service.execute(() -> {
                HttpRequest request = HttpUtil.createGet(url);
                HttpResponse response = request.execute();
                System.out.println(" ===>> " + response.getStatus());
            });
        }
    }

}
