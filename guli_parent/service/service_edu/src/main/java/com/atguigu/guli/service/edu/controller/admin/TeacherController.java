package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.common.base.result.ResultCodeEnum;
import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.vo.TeacherQueryVo;
import com.atguigu.guli.service.edu.feign.OssFileService;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@CrossOrigin //允许跨域请求
@RestController
@Slf4j
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OssFileService ossFileService;

    @GetMapping("list")
    public ResultData listAll(){
        List<Teacher> list = teacherService.list();
        return ResultData.ok().data("items",list);
    }

    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id){
        //删除图片
        teacherService.removeAvatarById(id);
        //删除讲师
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

    @DeleteMapping("batchRemove")
    public ResultData batchRemove(@RequestBody List<String> idList){
        boolean result = teacherService.removeByIds(idList);
        if(result){
            return ResultData.ok().message("删除成功");
        }else {
            return ResultData.error().message("数据不存在");
        }
    }


    @GetMapping("list/name/{key}")
    public ResultData selectNameListByKey(@PathVariable String key){
        List<Map<String, Object>> nameList = teacherService.selectNameListByKey(key);
        return ResultData.ok().data("nameList", nameList);
    }


    @GetMapping("test")
    public ResultData test(){
        try {
            ossFileService.test();
            log.info("test");
        } catch (Exception e) {
            throw new GuliException(ResultCodeEnum.TIME_OUT);
        }
        return ResultData.ok();
    }

    @ApiOperation("测试并发")
    @GetMapping("test_concurrent")
    public ResultData testConcurrent(){
        log.info("test_concurrent");
        return ResultData.ok();
    }

    @GetMapping("/message1")
    public String message1() {
        return "message1";
    }

    @GetMapping("/message2")
    public String message2() {
        return "message2";
    }

}

