package com.kenneth.guli.service.edu.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.entity.Course;
import com.kenneth.guli.service.edu.entity.vo.ChapterVo;
import com.kenneth.guli.service.edu.entity.vo.WebCourseQueryVo;
import com.kenneth.guli.service.edu.entity.vo.WebCourseVo;
import com.kenneth.guli.service.edu.service.ChapterService;
import com.kenneth.guli.service.edu.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ApiCourseController
 * @Author zengyihang
 * @Date: 2021-02-07 13:58
 */
@CrossOrigin
@RestController
@RequestMapping("/api/edu/course")
public class ApiCourseController {

    @Resource
    private CourseService courseService;

    @Resource
    private ChapterService chapterService;

    /**
     * 课程列表
     * @param webCourseQueryVo
     * @return
     */
    @GetMapping("list")
    public ResultData list(WebCourseQueryVo webCourseQueryVo){
        List<Course> courseList = courseService.webSelectList(webCourseQueryVo);
        return  ResultData.ok().data("courseList", courseList);
    }

    /**
     * 根据ID查询课程
     * @param courseId
     * @return
     */
    @GetMapping("get/{courseId}")
    public ResultData getById(@PathVariable String courseId){

        //查询课程信息和讲师信息
        WebCourseVo webCourseVo = courseService.selectWebCourseVoById(courseId);

        //查询当前课程的章节信息
        List<ChapterVo> chapterVoList = chapterService.nestedList(courseId);

        return ResultData.ok().data("course", webCourseVo).data("chapterVoList", chapterVoList);
    }
}
