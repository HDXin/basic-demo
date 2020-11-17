package top.atstudy.basic.json;

import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/28 15:16
 * @Desc:
 */
public class JsonConvertTest {

    @Test
    public void testBeanToJson() throws JsonProcessingException {

        Order order = getOrder();
        String str = new ObjectMapper().writeValueAsString(order);
        System.out.println(" ===>> " + str);

    }

    @Test
    public void testJsonToBean() throws IOException {

        Order order = getOrder();
        String str = new ObjectMapper().writeValueAsString(order);
//        Order temp = new ObjectMapper().readValue(str, Order.class);
        Map<String, Object> temp = new ObjectMapper().readValue(str, Map.class);
        System.out.println(" ===>> source: " + temp.toString());

        sortMap(temp);
        System.out.println(" ===>> after: " + temp);

    }

    private Order getOrder(){

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().getLeastSignificantBits());
        order.setOperator(new Operator(UUID.randomUUID().getLeastSignificantBits(), "harley", "abc.jpg"));

        List<OrderItem> items = new ArrayList<>();
        order.setItems(items);

        items.add(new OrderItem(UUID.randomUUID().getLeastSignificantBits(), "法式小面包", new BigDecimal(15.61), 3));
        items.add(new OrderItem(UUID.randomUUID().getLeastSignificantBits(), "可口可乐", new BigDecimal(11.28), 1));
        items.add(new OrderItem(UUID.randomUUID().getLeastSignificantBits(), "自嗨锅", new BigDecimal(21.98), 2));

        return order;
    }

    public static Map<String, Object> sortMap(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortMap = new TreeMap<String, Object>((k1, k2) -> k1.compareTo(k2));
        sortMap.putAll(map);
        return sortMap;
    }


}
