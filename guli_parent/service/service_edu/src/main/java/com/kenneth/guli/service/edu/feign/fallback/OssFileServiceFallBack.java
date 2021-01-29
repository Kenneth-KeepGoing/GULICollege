package com.kenneth.guli.service.edu.feign.fallback;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName OssFileServiceFallBack
 * @Author zengyihang
 * @Date: 2021-01-26 14:07
 */

@Service
@Slf4j
public class OssFileServiceFallBack implements OssFileService {
    @Override
    public ResultData test() {
        return ResultData.error();
    }

    @Override
    public ResultData removeFile(String url) {
        log.info("熔断保护");
        return ResultData.error();
    }
}
