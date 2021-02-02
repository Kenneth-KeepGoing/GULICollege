package com.kenneth.guli.service.edu.service.impl;

import com.kenneth.guli.service.edu.entity.Video;
import com.kenneth.guli.service.edu.feign.VodMediaService;
import com.kenneth.guli.service.edu.mapper.VideoMapper;
import com.kenneth.guli.service.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author Kenneth
 * @since 2021-01-12
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Resource
    private VodMediaService vodMediaService;

    @Override
    public void removeMediaVideoById(String id) {
        log.warn("VideoServiceImpl：video id = " + id);
        //根据videoid找到视频id
        Video video = baseMapper.selectById(id);
        String videoSourceId = video.getVideoSourceId();
        log.warn("VideoServiceImpl：videoSourceId= " + videoSourceId);
        vodMediaService.removeVideo(videoSourceId);
    }
}
