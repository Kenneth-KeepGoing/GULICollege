package com.atguigu.guli.service.edu.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubjectVo
 * @Author zengyihang
 * @Date: 2021-01-26 16:27
 */
public class SubjectVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private Integer sort;

    private List<SubjectVo> children = new ArrayList<>();

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

    public List<SubjectVo> getChildren() {
        return children;
    }

    public void setChildren(List<SubjectVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SubjectVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                '}';
    }
}
