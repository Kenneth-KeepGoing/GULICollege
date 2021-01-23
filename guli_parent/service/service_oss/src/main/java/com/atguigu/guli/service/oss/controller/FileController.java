package com.atguigu.guli.service.oss.controller;

import com.atguigu.guli.common.base.result.ResultCodeEnum;
import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.oss.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Zyh
 * @Date: 2021/1/22 19:29
 * @Version: 1.0
 */

@CrossOrigin //跨域
@RestController
@Slf4j
@RequestMapping("/admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @param file
     */
    @PostMapping("upload")
    public ResultData upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("module") String module) {

        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);
            //返回r对象
            return ResultData.ok().message("文件上传成功").data("url", uploadUrl);
        } catch (IOException e) {
            throw new GuliException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        }
    }

    @DeleteMapping("remove")
    public ResultData removeFile(@RequestBody String url) {
        fileService.removeFile(url);
        return ResultData.ok().message("文件刪除成功");
    }

    @GetMapping("test")
    public ResultData test() {
        log.info("oss test被调用");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new GuliException(ResultCodeEnum.TIME_OUT);
        }
        return ResultData.ok();
    }
}
