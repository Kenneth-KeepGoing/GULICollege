package com.kenneth.guli.service.edu.entity.vo;

import java.io.Serializable;

/**
 * @ClassName CourseVo
 * @Author zengyihang
 * @Date: 2021-01-27 14:46
 */
public class CourseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String subjectParentTitle;

    private String subjectTitle;

    private String teacherName;

    private Integer lessonNum;

    private String price;

    private String cover;

    private Long buyCount;

    private Long viewCount;

    private String status;

    private String gmtCreate;

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

    public String getSubjectParentTitle() {
        return subjectParentTitle;
    }

    public void setSubjectParentTitle(String subjectParentTitle) {
        this.subjectParentTitle = subjectParentTitle;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Long buyCount) {
        this.buyCount = buyCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subjectParentTitle='" + subjectParentTitle + '\'' +
                ", subjectTitle='" + subjectTitle + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", lessonNum=" + lessonNum +
                ", price='" + price + '\'' +
                ", cover='" + cover + '\'' +
                ", buyCount=" + buyCount +
                ", viewCount=" + viewCount +
                ", status='" + status + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                '}';
    }
}
