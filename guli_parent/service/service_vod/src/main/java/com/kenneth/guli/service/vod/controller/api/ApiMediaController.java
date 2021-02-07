package com.kenneth.guli.service.vod.controller.api;

import com.kenneth.guli.common.base.result.ResultCodeEnum;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.ExceptionUtils;
import com.kenneth.guli.service.base.exception.GuliException;
import com.kenneth.guli.service.vod.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName ApiMediaController
 * @Author zengyihang
 * @Date: 2021-02-07 15:18
 */
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/vod/media")
@Slf4j
public class ApiMediaController {

    @Resource
    private VideoService videoService;

    @GetMapping("get-play-auth/{videoSourceId}")
    public ResultData getPlayAuth(@PathVariable String videoSourceId){
        try{
            String playAuth = videoService.getPlayAuth(videoSourceId);
            return  ResultData.ok().message("获取播放凭证成功").data("playAuth", playAuth);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new GuliException(ResultCodeEnum.FETCH_PLAYAUTH_ERROR);
        }
    }
}
