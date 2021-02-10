package com.kenneth.guli.service.sms.service;

import com.aliyuncs.exceptions.ClientException;

/**
 * @Author: Zyh
 * @Date: 2021/2/10 11:44
 * @Version: 1.0
 */
public interface SmsService {
    void send(String mobile, String checkCode) throws ClientException;
}
