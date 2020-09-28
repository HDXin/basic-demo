package top.atstudy.basic.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/9/28 14:16
 * @Desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator implements Serializable {

    private Long userId;

    private String nickname;

    private String headimgurl;

}
