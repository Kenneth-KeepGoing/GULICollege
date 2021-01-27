package com.atguigu.guli.service.edu.entity.vo;

import java.io.Serializable;

/**
 * @Author: Zyh
 * @Date: 2021/1/27 22:14
 * @Version: 1.0
 */
public class CoursePublishVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String cover;

    private Integer lessonNum;

    private String subjectParentTitle;

    private String subjectTitle;

    private String teacherName;

    private String price;//只用于显示

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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoursePublishVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", lessonNum=" + lessonNum +
                ", subjectParentTitle='" + subjectParentTitle + '\'' +
                ", subjectTitle='" + subjectTitle + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
