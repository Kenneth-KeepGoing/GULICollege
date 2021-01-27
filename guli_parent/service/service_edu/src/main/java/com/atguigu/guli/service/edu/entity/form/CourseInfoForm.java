package com.atguigu.guli.service.edu.entity.form;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName CourseInfoForm
 * @Author zengyihang
 * @Date: 2021-01-27 10:19
 */
public class CourseInfoForm  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程ID
     */
    private String id;
    /**
     * 课程讲师ID
     */
    private String teacherId;
    /**
     * 课程专业ID
     */
    private String subjectId;
    /**
     * 课程专业父级ID
     */
    private String subjectParentId;
    /**
     * 课程标题
     */
    private String title;
    /**
     * 课程销售价格，设置为0则可免费观看
     */
    private BigDecimal price;
    /**
     * 总课时
     */
    private Integer lessonNum;
    /**
     * 课程封面图片路径
     */
    private String cover;
    /**
     * 课程简介
     */
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(String subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseInfoForm{" +
                "id='" + id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", subjectParentId='" + subjectParentId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", lessonNum=" + lessonNum +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
