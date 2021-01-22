package com.atguigu.guli.service.oss.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Zyh
 * @Date: 2021/1/22 19:06
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix="aliyun.oss")
public class OssProperties {

    private String endpoint;

    private String keyid;

    private String keysecret;

    private String bucketname;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getKeysecret() {
        return keysecret;
    }

    public void setKeysecret(String keysecret) {
        this.keysecret = keysecret;
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }

    @Override
    public String toString() {
        return "OssProperties{" +
                "endpoint='" + endpoint + '\'' +
                ", keyid='" + keyid + '\'' +
                ", keysecret='" + keysecret + '\'' +
                ", bucketname='" + bucketname + '\'' +
                '}';
    }
}
