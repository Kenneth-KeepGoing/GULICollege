package com.atguigu.guli.service.edu.feign;

import com.atguigu.guli.common.base.result.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: Zyh
 * @Date: 2021/1/23 15:13
 * @Version: 1.0
 */
@Service
@FeignClient("service-oss")
public interface OssFileService {

    @GetMapping("/admin/oss/file/test")
    ResultData test();

    @DeleteMapping("/admin/oss/file/remove")
    ResultData removeFile(@RequestBody String url);
}
