package com.kenneth.guli.service.oss.service;

import java.io.InputStream;

/**
 * @Author: Zyh
 * @Date: 2021/1/22 19:09
 * @Version: 1.0
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    void removeFile(String url);
}
