package com.kenneth.guli.service.sms.controller;

import com.aliyuncs.exceptions.ClientException;
import com.kenneth.guli.common.base.result.ResultCodeEnum;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.FormUtils;
import com.kenneth.guli.common.base.util.RandomUtils;
import com.kenneth.guli.service.base.exception.GuliException;
import com.kenneth.guli.service.sms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Zyh
 * @Date: 2021/2/10 11:41
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api/sms")
@CrossOrigin //跨域
@Slf4j
public class ApiSmsController {

    @Resource
    private SmsService smsService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("send/{mobile}")
    public ResultData getCode(@PathVariable String mobile) throws ClientException {

        //校验手机号是否合法
        if(StringUtils.isEmpty(mobile) || !FormUtils.isMobile(mobile)) {
            log.error("请输入正确的手机号码 ");
            throw new GuliException(ResultCodeEnum.LOGIN_PHONE_ERROR);
        }

        //生成验证码
        String checkCode = RandomUtils.getFourBitRandom();
        //发送验证码
        smsService.send(mobile, checkCode);
        //将验证码存入redis缓存
        redisTemplate.opsForValue().set(mobile, checkCode, 5, TimeUnit.MINUTES);

        return ResultData.ok().message("短信发送成功");
    }
}
