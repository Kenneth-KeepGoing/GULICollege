package com.kenneth.guli.service.edu.feign;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.feign.fallback.VodMediaServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName VodMediaService
 * @Author zengyihang
 * @Date: 2021-02-02 14:39
 */

@Service
@FeignClient(value = "service-vod", fallback = VodMediaServiceFallBack.class)
public interface VodMediaService {

    @DeleteMapping("/admin/vod/media/remove/{vodId}")
    ResultData removeVideo(@PathVariable("vodId") String vodId);
}
