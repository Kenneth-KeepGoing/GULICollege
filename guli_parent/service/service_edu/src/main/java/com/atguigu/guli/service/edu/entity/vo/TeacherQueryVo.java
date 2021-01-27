package com.atguigu.guli.service.edu.entity.vo;

import java.io.Serializable;

/**
 * @ClassName TeacherQueryVo
 * @Author zengyihang
 * @Date: 2021-01-13 11:41
 */
public class TeacherQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer level;

    private String joinDateBegin;

    private String joinDateEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getJoinDateBegin() {
        return joinDateBegin;
    }

    public void setJoinDateBegin(String joinDateBegin) {
        this.joinDateBegin = joinDateBegin;
    }

    public String getJoinDateEnd() {
        return joinDateEnd;
    }

    public void setJoinDateEnd(String joinDateEnd) {
        this.joinDateEnd = joinDateEnd;
    }

    @Override
    public String toString() {
        return "TeacherQueryVo{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", joinDateBegin='" + joinDateBegin + '\'' +
                ", joinDateEnd='" + joinDateEnd + '\'' +
                '}';
    }
}
