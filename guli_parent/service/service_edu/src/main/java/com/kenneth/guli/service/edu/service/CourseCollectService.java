package com.kenneth.guli.service.edu.service;

import com.kenneth.guli.service.edu.entity.CourseCollect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kenneth.guli.service.edu.entity.vo.CourseCollectVo;

import java.util.List;

/**
 * <p>
 * 课程收藏 服务类
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
public interface CourseCollectService extends IService<CourseCollect> {

    boolean isCollect(String courseId, String id);

    void saveCourseCollect(String courseId, String id);

    List<CourseCollectVo> selectListByMemberId(String id);

    boolean removeCourseCollect(String courseId, String id);
}
