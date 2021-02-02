package com.kenneth.guli.service.vod.service;

import com.aliyuncs.exceptions.ClientException;

import java.io.InputStream;
import java.util.List;

/**
 * @ClassName VideoService
 * @Author zengyihang
 * @Date: 2021-02-02 11:25
 */
public interface VideoService {
    /**
     * 上传视频
     * @param file
     * @param originalFilename
     * @return String
     */
    String uploadVideo(InputStream file, String originalFilename);

    /**
     * 删除视频
     * @param videoId
     * @throws ClientException
     */
    void removeVideo(String videoId) throws ClientException;

    void removeVideoByIdList(List<String> videoIdList) throws ClientException;
}
