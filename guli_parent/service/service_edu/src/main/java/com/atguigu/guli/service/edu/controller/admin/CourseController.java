package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.service.edu.entity.form.CourseInfoForm;
import com.atguigu.guli.service.edu.entity.vo.CoursePublishVo;
import com.atguigu.guli.service.edu.entity.vo.CourseQueryVo;
import com.atguigu.guli.service.edu.entity.vo.CourseVo;
import com.atguigu.guli.service.edu.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
@RestController
@Slf4j
@RequestMapping("/admin/edu/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * 插入课程信息
     */
    @PostMapping("save-course-info")
    public ResultData saveCourseInfo(@RequestBody CourseInfoForm courseInfoForm){
        String courseId = courseService.saveCourseInfo(courseInfoForm);
        return ResultData.ok().data("courseId", courseId).message("保存成功");
    }

    /**
     * 根据id查询课程信息
     */
    @GetMapping("course-info/{id}")
    public ResultData getById(@PathVariable String id){
        CourseInfoForm courseInfoForm = courseService.getCourseInfoById(id);
        if (courseInfoForm != null) {
            return ResultData.ok().data("item", courseInfoForm);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据id修改课程信息
     */
    @PutMapping("update-course-info")
    public ResultData updateCourseInfoById(@RequestBody CourseInfoForm courseInfoForm){
        courseService.updateCourseInfoById(courseInfoForm);
        return ResultData.ok().message("修改成功");
    }

    /**
     * 分页查询课程信息
     */
    @GetMapping("list/{page}/{limit}")
    public ResultData index(@PathVariable Long page, @PathVariable Long limit, CourseQueryVo courseQueryVo){
        IPage<CourseVo> pageModel = courseService.selectPage(page, limit, courseQueryVo);
        List<CourseVo> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  ResultData.ok().data("total", total).data("rows", records);
    }

    /**
     * 根据ID删除课程
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id){
        //TODO 删除视频：VOD
        //在此处调用vod中的删除视频文件的接口

        //删除封面：OSS
        courseService.removeCoverById(id);
        //删除课程
        boolean result = courseService.removeCourseById(id);
        if (result) {
            return ResultData.ok().message("删除成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据ID获取课程发布信息
     * @param id
     * @return
     */
    @GetMapping("course-publish/{id}")
    public ResultData getCoursePublishVoById(@PathVariable String id){
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVoById(id);
        if (coursePublishVo != null) {
            return ResultData.ok().data("item", coursePublishVo);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据id发布课程
     * @param id
     * @return
     */
    @PutMapping("publish-course/{id}")
    public ResultData publishCourseById(@PathVariable String id){
        boolean result = courseService.publishCourseById(id);
        if (result) {
            return ResultData.ok().message("发布成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

}

