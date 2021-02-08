package com.kenneth.guli.service.edu.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.entity.Course;
import com.kenneth.guli.service.edu.entity.Teacher;
import com.kenneth.guli.service.edu.service.CourseService;
import com.kenneth.guli.service.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ApiIndexController
 * @Author zengyihang
 * @Date: 2021-02-08 11:07
 */
@CrossOrigin
@RestController
@RequestMapping("/api/edu/index")
public class ApiIndexController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 课程列表
     * @return
     */
    @GetMapping
    public ResultData index(){

        //获取首页最热门前8条课程数据
        List<Course> courseList = courseService.selectHotCourse();
        //获取首页推荐前4条讲师数据
        List<Teacher> teacherList = teacherService.selectHotTeacher();

        return ResultData.ok().data("courseList", courseList).data("teacherList", teacherList);
    }
}
