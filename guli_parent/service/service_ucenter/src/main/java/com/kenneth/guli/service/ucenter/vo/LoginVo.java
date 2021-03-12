package com.kenneth.guli.service.ucenter.vo;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 14:25
 * @Version: 1.0
 */
public class LoginVo {

    private static final long serialVersionUID = 1L;

    private String mobile;

    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
