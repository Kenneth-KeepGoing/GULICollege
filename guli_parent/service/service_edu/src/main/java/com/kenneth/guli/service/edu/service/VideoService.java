package com.kenneth.guli.service.edu.service;

import com.kenneth.guli.service.edu.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
public interface VideoService extends IService<Video> {
    void removeMediaVideoById(String id);
}
