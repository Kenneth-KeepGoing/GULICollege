package com.atguigu.guli.service.edu.entity.vo;

import java.io.Serializable;

/**
 * @Author: Zyh
 * @Date: 2021/1/27 22:39
 * @Version: 1.0
 */
public class VideoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 节点名称
     */
    private String title;

    /**
     * 是否可以试听：0收费 1免费
     */
    private Boolean free;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 云端视频资源
     */
    private String videoSourceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getVideoSourceId() {
        return videoSourceId;
    }

    public void setVideoSourceId(String videoSourceId) {
        this.videoSourceId = videoSourceId;
    }

    @Override
    public String toString() {
        return "VideoVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", free=" + free +
                ", sort=" + sort +
                ", videoSourceId='" + videoSourceId + '\'' +
                '}';
    }
}
