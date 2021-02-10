package com.kenneth.guli.service.ucenter.vo;

import java.io.Serializable;

/**
 * @Author: Zyh
 * @Date: 2021/2/10 12:19
 * @Version: 1.0
 */
public class RegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nickname;

    private String mobile;

    private String password;

    private String code;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegisterVo{" +
                "nickname='" + nickname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
