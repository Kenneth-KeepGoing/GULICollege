package com.kenneth.guli.service.edu.service;

import com.kenneth.guli.service.edu.entity.Course;
import com.kenneth.guli.service.edu.entity.form.CourseInfoForm;
import com.kenneth.guli.service.edu.entity.vo.CoursePublishVo;
import com.kenneth.guli.service.edu.entity.vo.CourseQueryVo;
import com.kenneth.guli.service.edu.entity.vo.CourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    IPage<CourseVo> selectPage(Long page, Long limit, CourseQueryVo courseQueryVo);

    boolean removeCoverById(String id);

    boolean removeCourseById(String id);

    CoursePublishVo getCoursePublishVoById(String id);

    boolean publishCourseById(String id);
}