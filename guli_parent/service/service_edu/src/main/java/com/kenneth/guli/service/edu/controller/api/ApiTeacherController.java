package com.kenneth.guli.service.edu.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.entity.Teacher;
import com.kenneth.guli.service.edu.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ApiTeacherController
 * @Author zengyihang
 * @Date: 2021-02-07 10:47
 */
@CrossOrigin
@RestController
@RequestMapping("/api/edu/teacher")
public class ApiTeacherController {

    @Resource
    private TeacherService teacherService;

    /**
     * 所有讲师列表
     * @return
     */
    @GetMapping("list")
    public ResultData listAll(){
        List<Teacher> list = teacherService.list(null);
        return ResultData.ok().data("items", list).message("获取讲师列表成功");
    }

    /**
     * 获取讲师
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResultData get(@PathVariable String id) {
        Map<String, Object> map = teacherService.selectTeacherInfoById(id);
        return ResultData.ok().data(map);
    }
}
