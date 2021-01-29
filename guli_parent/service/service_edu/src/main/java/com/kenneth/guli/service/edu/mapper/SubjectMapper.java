package com.kenneth.guli.service.edu.mapper;

import com.kenneth.guli.service.edu.entity.Subject;
import com.kenneth.guli.service.edu.entity.vo.SubjectVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
public interface SubjectMapper extends BaseMapper<Subject> {
    List<SubjectVo> selectNestedListByParentId(String parentId);
}
