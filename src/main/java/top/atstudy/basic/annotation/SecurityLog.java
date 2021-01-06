package top.atstudy.basic.annotation;

import java.lang.annotation.*;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/12/16 9:56
 * @Desc:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityLog {

    String[] matchParamFields() default {};

    String[] matchVOFields() default {};

}
