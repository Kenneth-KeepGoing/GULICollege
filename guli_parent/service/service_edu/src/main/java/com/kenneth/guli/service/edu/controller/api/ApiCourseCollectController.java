package com.kenneth.guli.service.edu.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.JwtInfo;
import com.kenneth.guli.common.base.util.JwtUtils;
import com.kenneth.guli.service.edu.entity.vo.CourseCollectVo;
import com.kenneth.guli.service.edu.service.CourseCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 16:36
 * @Version: 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/edu/course-collect")
@Slf4j
public class ApiCourseCollectController {

    @Resource
    private CourseCollectService courseCollectService;

    /**
     * 判断是否收藏
     * @param courseId
     * @param request
     * @return
     */
    @GetMapping("auth/is-collect/{courseId}")
    public ResultData isCollect(@PathVariable String courseId, HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        boolean isCollect = courseCollectService.isCollect(courseId, jwtInfo.getId());
        return ResultData.ok().data("isCollect", isCollect);
    }

    /**
     * 收藏课程
     * @param courseId
     * @param request
     * @return
     */
    @PostMapping("auth/save/{courseId}")
    public ResultData save(@PathVariable String courseId, HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        courseCollectService.saveCourseCollect(courseId, jwtInfo.getId());
        return ResultData.ok();
    }

    /**
     * 获取课程收藏列表
     * @param request
     * @return
     */
    @GetMapping("auth/list")
    public ResultData collectList(HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        List<CourseCollectVo> list = courseCollectService.selectListByMemberId(jwtInfo.getId());
        return ResultData.ok().data("items", list);
    }

    /**
     * 取消收藏课程
     * @param courseId
     * @param request
     * @return
     */
    @DeleteMapping("auth/remove/{courseId}")
    public ResultData remove(@PathVariable String courseId, HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        boolean result = courseCollectService.removeCourseCollect(courseId, jwtInfo.getId());
        if (result) {
            return ResultData.ok().message("已取消");
        } else {
            return ResultData.error().message("取消失败");
        }
    }
}