package com.kenneth.guli.service.base.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 15:19
 * @Version: 1.0
 */
public class CourseDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;//课程ID
    private String title;//课程标题
    private BigDecimal price;//课程销售价格，设置为0则可免费观看
    private String cover;//课程封面图片路径
    private String teacherName;//课程讲师

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", cover='" + cover + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
