package top.atstudy.basic.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/28 14:16
 * @Desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private Long orderId;

    private Operator operator;

    private List<OrderItem> items = new ArrayList<>();


}
