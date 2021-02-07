package com.kenneth.guli.service.cms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kenneth.guli.service.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 推荐位
 * </p>
 *
 * @author Kenneth
 * @since 2021-02-07
 */
@TableName("cms_ad_type")
@ApiModel(value="AdType对象", description="推荐位")
public class AdType extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标题")
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "AdType{" +
        "title=" + title +
        "}";
    }
}
