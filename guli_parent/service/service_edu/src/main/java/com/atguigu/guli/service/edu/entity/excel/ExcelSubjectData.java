package com.atguigu.guli.service.edu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @ClassName ExcelSubjectData
 * @Author zengyihang
 * @Date: 2021-01-26 15:34
 */
public class ExcelSubjectData {

    @ExcelProperty(value = "一级分类")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类")
    private String levelTwoTitle;

    public String getLevelOneTitle() {
        return levelOneTitle;
    }

    public void setLevelOneTitle(String levelOneTitle) {
        this.levelOneTitle = levelOneTitle;
    }

    public String getLevelTwoTitle() {
        return levelTwoTitle;
    }

    public void setLevelTwoTitle(String levelTwoTitle) {
        this.levelTwoTitle = levelTwoTitle;
    }

    @Override
    public String toString() {
        return "ExcelSubjectData{" +
                "levelOneTitle='" + levelOneTitle + '\'' +
                ", levelTwoTitle='" + levelTwoTitle + '\'' +
                '}';
    }
}
