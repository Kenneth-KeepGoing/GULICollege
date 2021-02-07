package com.kenneth.guli.service.edu.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.edu.entity.vo.SubjectVo;
import com.kenneth.guli.service.edu.service.SubjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ApiSubjectController
 * @Author zengyihang
 * @Date: 2021-02-07 14:04
 */
@CrossOrigin
@RestController
@RequestMapping("/api/edu/subject")
public class ApiSubjectController {

    @Resource
    private SubjectService subjectService;

    /**
     * 嵌套数据列表
     * @return
     */
    @GetMapping("nested-list")
    public ResultData nestedList(){
        List<SubjectVo> subjectVoList = subjectService.nestedList();
        return ResultData.ok().data("items", subjectVoList);
    }
}