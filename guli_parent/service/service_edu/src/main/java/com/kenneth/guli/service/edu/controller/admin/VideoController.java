package com.kenneth.guli.service.edu.controller.admin;


import com.kenneth.guli.common.base.result.ResultCodeEnum;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.ExceptionUtils;
import com.kenneth.guli.service.base.exception.GuliException;
import com.kenneth.guli.service.edu.entity.Video;
import com.kenneth.guli.service.edu.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/edu/video")
@Slf4j
public class VideoController {
    @Resource
    private VideoService videoService;

    /**
     * 新增课时
     * @param video
     * @return
     */
    @PostMapping("save")
    public ResultData save(@RequestBody Video video){
        boolean result = videoService.save(video);
        if (result) {
            return ResultData.ok().message("保存成功");
        } else {
            return ResultData.error().message("保存失败");
        }
    }

    /**
     * 根据id查询课时
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResultData getById(@PathVariable String id){
        Video video = videoService.getById(id);
        if (video != null) {
            return ResultData.ok().data("item", video);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据id修改课时
     * @param video
     * @return
     */
    @PutMapping("update")
    public ResultData updateById(@RequestBody Video video){
        boolean result = videoService.updateById(video);
        if (result) {
            return ResultData.ok().message("修改成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据ID删除课时
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id){
        //在此处调用vod中的删除视频文件的接口
        videoService.removeMediaVideoById(id);
        boolean result = videoService.removeById(id);
        if (result) {
            return ResultData.ok().message("删除成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }
}

