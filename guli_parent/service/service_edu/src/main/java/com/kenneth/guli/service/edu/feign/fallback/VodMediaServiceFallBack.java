package com.kenneth.guli.service.edu.feign.fallback;

import com.kenneth.guli.common.base.result.ResultData;

import com.kenneth.guli.service.edu.feign.VodMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName VodMediaServiceFallBack
 * @Author zengyihang
 * @Date: 2021-02-02 14:41
 */
@Service
@Slf4j
public class VodMediaServiceFallBack implements VodMediaService {
    @Override
    public ResultData removeVideo(String vodId) {
        log.info("熔断保护");
        return ResultData.error();
    }

    @Override
    public ResultData removeVideoByIdList(List<String> videoIdList) {
        log.info("熔断保护");
        return ResultData.error().message("调用超时");
    }
}