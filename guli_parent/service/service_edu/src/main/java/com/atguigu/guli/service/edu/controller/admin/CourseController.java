package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.service.edu.entity.form.CourseInfoForm;
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

    @PostMapping("save-course-info")
    public ResultData saveCourseInfo(@RequestBody CourseInfoForm courseInfoForm){
        String courseId = courseService.saveCourseInfo(courseInfoForm);
        return ResultData.ok().data("courseId", courseId).message("保存成功");
    }

    @GetMapping("course-info/{id}")
    public ResultData getById(@PathVariable String id){
        CourseInfoForm courseInfoForm = courseService.getCourseInfoById(id);
        if (courseInfoForm != null) {
            return ResultData.ok().data("item", courseInfoForm);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    @PutMapping("update-course-info")
    public ResultData updateCourseInfoById(@RequestBody CourseInfoForm courseInfoForm){
        courseService.updateCourseInfoById(courseInfoForm);
        return ResultData.ok().message("修改成功");
    }


    @GetMapping("list/{page}/{limit}")
    public ResultData index(@PathVariable Long page, @PathVariable Long limit, CourseQueryVo courseQueryVo){
        IPage<CourseVo> pageModel = courseService.selectPage(page, limit, courseQueryVo);
        List<CourseVo> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  ResultData.ok().data("total", total).data("rows", records);
    }
}

