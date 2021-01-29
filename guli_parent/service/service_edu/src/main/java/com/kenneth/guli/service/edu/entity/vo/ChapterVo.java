package com.kenneth.guli.service.edu.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zyh
 * @Date: 2021/1/27 22:40
 * @Version: 1.0
 */
public class ChapterVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private Integer sort;

    private List<VideoVo> children = new ArrayList<>();

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<VideoVo> getChildren() {
        return children;
    }

    public void setChildren(List<VideoVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ChapterVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                '}';
    }
}
