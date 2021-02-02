package com.kenneth.guli.service.vod.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName VodProperties
 * @Author zengyihang
 * @Date: 2021-02-02 11:23
 */
@Component
@ConfigurationProperties(prefix="aliyun.vod")
public class VodProperties {

    private String keyid;

    private String keysecret;

    private String templateGroupId;

    private String workflowId;

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

    public String getTemplateGroupId() {
        return templateGroupId;
    }

    public void setTemplateGroupId(String templateGroupId) {
        this.templateGroupId = templateGroupId;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    @Override
    public String toString() {
        return "VodProperties{" +
                "keyid='" + keyid + '\'' +
                ", keysecret='" + keysecret + '\'' +
                ", templateGroupId='" + templateGroupId + '\'' +
                ", workflowId='" + workflowId + '\'' +
                '}';
    }
}
