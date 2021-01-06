package top.atstudy.basic.annotation;

import lombok.Data;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/12/16 10:02
 * @Desc:
 */
@Data
public class LoginVO {

    private Long userId;

    private String nickName;

    private Integer age;

    private String Email;

    private Integer gender;

}
