package com.kenneth.guli.service.edu.mapper;

import com.kenneth.guli.service.base.dto.CourseDto;
import com.kenneth.guli.service.edu.entity.Course;
import com.kenneth.guli.service.edu.entity.vo.CoursePublishVo;
import com.kenneth.guli.service.edu.entity.vo.CourseVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kenneth.guli.service.edu.entity.vo.WebCourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
public interface CourseMapper extends BaseMapper<Course> {

    List<CourseVo> selectPageByCourseQueryVo(
            //mp会自动组装分页：
            Page<CourseVo> pageParam,
            //mp会自动组装queryWrapper：
            //@Param(Constants.WRAPPER) 和 xml文件中的 ${ew.customSqlSegment} 对应
            @Param(Constants.WRAPPER) QueryWrapper<CourseVo> queryWrapper);

    CoursePublishVo selectCoursePublishVoById(String id);

    WebCourseVo selectWebCourseVoById(String courseId);

    CourseDto selectCourseDtoById(String courseId);
}
