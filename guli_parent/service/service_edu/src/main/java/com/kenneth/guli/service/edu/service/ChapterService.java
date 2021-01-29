package com.kenneth.guli.service.edu.service;

import com.kenneth.guli.service.edu.entity.Chapter;
import com.kenneth.guli.service.edu.entity.vo.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
public interface ChapterService extends IService<Chapter> {

    boolean removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
