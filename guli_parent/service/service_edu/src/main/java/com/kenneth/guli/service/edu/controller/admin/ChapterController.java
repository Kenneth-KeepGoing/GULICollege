package com.kenneth.guli.service.edu.controller.admin;


import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.entity.Chapter;
import com.kenneth.guli.service.edu.entity.vo.ChapterVo;
import com.kenneth.guli.service.edu.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/admin/edu/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    /**
     * 新增章节
     * @param chapter
     * @return
     */
    @PostMapping("save")
    public ResultData save(@RequestBody Chapter chapter){
        boolean result = chapterService.save(chapter);
        if (result) {
            return ResultData.ok().message("保存成功");
        } else {
            return ResultData.error().message("保存失败");
        }
    }

    /**
     * 根据id查询章节
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResultData getById(@PathVariable String id){
        Chapter chapter = chapterService.getById(id);
        if (chapter != null) {
            return ResultData.ok().data("item", chapter);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据id修改章节
     * @param chapter
     * @return
     */
    @PutMapping("update")
    public ResultData updateById(@RequestBody Chapter chapter){

        boolean result = chapterService.updateById(chapter);
        if (result) {
            return ResultData.ok().message("修改成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据ID删除章节
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id){
        //TODO 删除视频：VOD
        //在此处调用vod中的删除视频文件的接口

        boolean result = chapterService.removeChapterById(id);
        if (result) {
            return ResultData.ok().message("删除成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 嵌套章节数据列表
     * @param courseId
     * @return
     */
    @GetMapping("nested-list/{courseId}")
    public ResultData nestedListByCourseId(@PathVariable String courseId){
        List<ChapterVo> chapterVoList = chapterService.nestedList(courseId);
        return ResultData.ok().data("items", chapterVoList);
    }
}

