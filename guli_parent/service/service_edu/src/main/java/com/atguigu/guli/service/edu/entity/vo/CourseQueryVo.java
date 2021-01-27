package com.atguigu.guli.service.edu.entity.vo;

import java.io.Serializable;

/**
 * @ClassName CourseQueryVo
 * @Author zengyihang
 * @Date: 2021-01-27 14:44
 */
public class CourseQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String teacherId;

    private String subjectParentId;

    private String subjectId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    @Override
    public String toString() {
        return "CourseQueryVo{" +
                "title='" + title + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", subjectParentId='" + subjectParentId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
}
