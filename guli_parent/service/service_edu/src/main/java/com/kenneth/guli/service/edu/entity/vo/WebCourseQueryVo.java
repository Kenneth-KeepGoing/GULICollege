package com.kenneth.guli.service.edu.entity.vo;

import java.io.Serializable;

/**
 * @ClassName WebCourseQueryVo
 * @Author zengyihang
 * @Date: 2021-02-07 13:57
 */
public class WebCourseQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer type; //价格正序：1，价格倒序：2

    private String subjectParentId;

    private String subjectId;

    private String buyCountSort;

    private String gmtCreateSort;

    private String priceSort;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(String subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getBuyCountSort() {
        return buyCountSort;
    }

    public void setBuyCountSort(String buyCountSort) {
        this.buyCountSort = buyCountSort;
    }

    public String getGmtCreateSort() {
        return gmtCreateSort;
    }

    public void setGmtCreateSort(String gmtCreateSort) {
        this.gmtCreateSort = gmtCreateSort;
    }

    public String getPriceSort() {
        return priceSort;
    }

    public void setPriceSort(String priceSort) {
        this.priceSort = priceSort;
    }

    @Override
    public String toString() {
        return "WebCourseQueryVo{" +
                "type=" + type +
                ", subjectParentId='" + subjectParentId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", buyCountSort='" + buyCountSort + '\'' +
                ", gmtCreateSort='" + gmtCreateSort + '\'' +
                ", priceSort='" + priceSort + '\'' +
                '}';
    }
}
