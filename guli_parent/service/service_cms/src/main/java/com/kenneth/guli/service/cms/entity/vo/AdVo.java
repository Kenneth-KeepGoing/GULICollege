package com.kenneth.guli.service.cms.entity.vo;

import java.io.Serializable;

/**
 * @ClassName AdVo
 * @Author zengyihang
 * @Date: 2021-02-07 16:41
 */
public class AdVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String id;

    private String title;

    private Integer sort;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AdVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", type='" + type + '\'' +
                '}';
    }
}