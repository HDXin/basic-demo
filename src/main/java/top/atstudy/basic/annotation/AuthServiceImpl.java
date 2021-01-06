package top.atstudy.basic.annotation;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2020/12/16 10:01
 * @Desc:
 */
public class AuthServiceImpl implements AuthService {

    @SecurityLog()
    @Override
    public LoginVO login(LoginParam param) {
        return new LoginVO();
    }
}
