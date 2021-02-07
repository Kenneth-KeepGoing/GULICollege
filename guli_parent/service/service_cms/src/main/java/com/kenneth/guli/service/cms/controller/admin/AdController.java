package com.kenneth.guli.service.cms.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.cms.entity.Ad;
import com.kenneth.guli.service.cms.entity.vo.AdVo;
import com.kenneth.guli.service.cms.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 广告推荐 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-02-07
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/admin/cms/ad")
@Slf4j
public class AdController {
    @Resource
    private AdService adService;

    /**
     * 新增推荐
     * @param ad
     * @return
     */
    @PostMapping("save")
    public ResultData save(@RequestBody Ad ad) {
        boolean result = adService.save(ad);
        if (result) {
            return ResultData.ok().message("保存成功");
        } else {
            return ResultData.error().message("保存失败");
        }
    }

    /**
     * 更新推荐
     * @param ad
     * @return
     */
    @PutMapping("update")
    public ResultData updateById(@RequestBody Ad ad) {
        boolean result = adService.updateById(ad);
        if (result) {
            return ResultData.ok().message("修改成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 根据id获取推荐信息
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResultData getById(@PathVariable String id) {
        Ad ad = adService.getById(id);
        if (ad != null) {
            return ResultData.ok().data("item", ad);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 推荐分页列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("list/{page}/{limit}")
    public ResultData listPage(@PathVariable Long page, @PathVariable Long limit) {
        IPage<AdVo> pageModel = adService.selectPage(page, limit);
        List<AdVo> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return ResultData.ok().data("total", total).data("rows", records);
    }

    /**
     * 根据ID删除推荐
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id) {
        //删除图片
        adService.removeAdImageById(id);
        //删除推荐
        boolean result = adService.removeById(id);
        if (result) {
            return ResultData.ok().message("删除成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }
}

