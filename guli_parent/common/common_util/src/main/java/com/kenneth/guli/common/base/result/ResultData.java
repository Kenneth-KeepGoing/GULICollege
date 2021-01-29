package com.kenneth.guli.common.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Kenneth
 * @since 2021/1/13
 */

@ApiModel(value = "全局统一返回结果")
public class ResultData {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public ResultData(){}

    public static ResultData ok(){
        ResultData resultData = new ResultData();
        resultData.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        resultData.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultData.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return resultData;
    }

    public static ResultData error(){
        ResultData resultData = new ResultData();
        resultData.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        resultData.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        resultData.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return resultData;
    }

    public static ResultData setResult(ResultCodeEnum resultCodeEnum){
        ResultData resultData = new ResultData();
        resultData.setSuccess(resultCodeEnum.getSuccess());
        resultData.setCode(resultCodeEnum.getCode());
        resultData.setMessage(resultCodeEnum.getMessage());
        return resultData;
    }

    public ResultData success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultData message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultData code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultData data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultData data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
