package top.atstudy.basic.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/28 14:16
 * @Desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {

    private Long orderItemId;

    private String productName;

    private BigDecimal price;

    private Integer quantity;

}
