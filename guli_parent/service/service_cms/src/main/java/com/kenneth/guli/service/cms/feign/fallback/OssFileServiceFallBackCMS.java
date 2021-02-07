package com.kenneth.guli.service.cms.feign.fallback;

import com.kenneth.guli.common.base.result.ResultData;



import com.kenneth.guli.service.cms.feign.OssFileServiceCMS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName OssFileServiceFallBack
 * @Author zengyihang
 * @Date: 2021-02-07 16:58
 */
@Service
@Slf4j
public class OssFileServiceFallBackCMS implements OssFileServiceCMS {
    @Override
    public ResultData removeFile(String url) {
        log.info("熔断保护");
        return ResultData.error().message("调用超时");
    }
}
