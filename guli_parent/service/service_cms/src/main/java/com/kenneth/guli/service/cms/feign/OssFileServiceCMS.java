package com.kenneth.guli.service.cms.feign;

import com.kenneth.guli.common.base.result.ResultData;

import com.kenneth.guli.service.cms.feign.fallback.OssFileServiceFallBackCMS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName OssFileService
 * @Author zengyihang
 * @Date: 2021-02-07 16:57
 */
@Service
@FeignClient(value = "service-oss", fallback = OssFileServiceFallBackCMS.class)
public interface OssFileServiceCMS {
    @DeleteMapping("/admin/oss/file/remove")
    ResultData removeFile(@RequestBody String url);
}
