package com.kenneth.guli.service.base.exception;

import com.kenneth.guli.common.base.result.ResultCodeEnum;

/**
 * @Author: Zyh
 * @Date: 2021/1/22 22:06
 * @Version: 1.0
 */
public class GuliException extends RuntimeException {

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public GuliException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                '}';
    }
}
