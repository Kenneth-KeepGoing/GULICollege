package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.common.base.result.ResultCodeEnum;
import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.common.base.util.ExceptionUtils;
import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.edu.entity.vo.SubjectVo;
import com.atguigu.guli.service.edu.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/admin/edu/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("import")
    public ResultData batchImport(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            subjectService.batchImport(inputStream);
            return ResultData.ok().message("批量导入成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new GuliException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
        }
    }

    @GetMapping("nested-list")
    public ResultData nestedList(){
        List<SubjectVo> subjectVoList = subjectService.nestedList();
        return ResultData.ok().data("items", subjectVoList);
    }
}

