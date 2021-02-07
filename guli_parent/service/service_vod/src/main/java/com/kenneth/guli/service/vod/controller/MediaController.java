package com.kenneth.guli.service.vod.controller;

import com.kenneth.guli.common.base.result.ResultCodeEnum;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.ExceptionUtils;
import com.kenneth.guli.service.base.exception.GuliException;
import com.kenneth.guli.service.vod.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MediaController
 * @Author zengyihang
 * @Date: 2021-02-02 11:43
 */
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/vod/media")
@Slf4j
public class MediaController {

    @Resource
    private VideoService videoService;

    /**
     * 上传视频
     * @param file
     * @return
     */
    @PostMapping("upload")
    public ResultData uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String videoId = videoService.uploadVideo(inputStream, originalFilename);
            return ResultData.ok().message("视频上传成功").data("videoId", videoId);
        } catch (IOException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new GuliException(ResultCodeEnum.VIDEO_UPLOAD_TOMCAT_ERROR);
        }
    }

    /**
     * 删除视频
     * @param vodId
     * @return
     */
    @DeleteMapping("remove/{vodId}")
    public ResultData removeVideo(@PathVariable String vodId){
        try {
            videoService.removeVideo(vodId);
            return ResultData.ok().message("视频删除成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new GuliException(ResultCodeEnum.VIDEO_DELETE_ALIYUN_ERROR);
        }
    }

    /**
     * 批量删除
     * @param videoIdList
     * @return
     */
    @DeleteMapping("remove")
    public ResultData removeVideoByIdList(@RequestBody List<String> videoIdList){
        try {
            videoService.removeVideoByIdList(videoIdList);
            return  ResultData.ok().message("视频删除成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new GuliException(ResultCodeEnum.VIDEO_DELETE_ALIYUN_ERROR);
        }
    }
}
