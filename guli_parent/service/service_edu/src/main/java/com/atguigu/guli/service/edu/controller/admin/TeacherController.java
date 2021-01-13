package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.vo.TeacherQueryVo;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("list")
    public ResultData listAll(){
        List<Teacher> list = teacherService.list();
        return ResultData.ok().data("items",list);
    }

    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id){
        boolean result = teacherService.removeById(id);
        if(result){
            return ResultData.ok().message("删除成功");
        }else {
            return ResultData.error().message("数据不存在");
        }
    }

    @GetMapping("list/{page}/{limit}")
    public ResultData listPage(@PathVariable @NotNull Long page,
                               @PathVariable @NotNull Long limit,
                               TeacherQueryVo teacherQueryVo){
        Page<Teacher> teacherPage = new Page<>(page, limit);
        IPage<Teacher> pageParam = teacherService.selectPage(teacherPage,teacherQueryVo);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return ResultData.ok().data("total",total).data("rows",records);
    }
    @PostMapping("save")
    public ResultData save(@RequestBody Teacher teacher){
        teacherService.save(teacher);
        return ResultData.ok().message("保存成功");
    }

    @PostMapping("update")
    public ResultData updateById(@RequestBody Teacher teacher){
        boolean result = teacherService.updateById(teacher);
        if(result){
            return ResultData.ok().message("修改成功");
        }else {
            return ResultData.error().message("修改失败");
        }
    }

    @GetMapping("get/{id}")
    public ResultData getById(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher!=null){
            return ResultData.ok().data("item",teacher);
        }else {
            return ResultData.error().message("数据不存在");
        }
    }
}

