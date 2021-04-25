package top.atstudy.basic.netty.netty.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/23 17:43
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO implements Serializable {

    private String date;

    private String msg;

}