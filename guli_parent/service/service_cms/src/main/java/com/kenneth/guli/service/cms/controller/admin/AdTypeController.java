package com.kenneth.guli.service.cms.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.cms.entity.AdType;
import com.kenneth.guli.service.cms.service.AdTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 推荐位 前端控制器
 * </p>
 *
 * @author Kenneth
 * @since 2021-02-07
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/admin/cms/ad-type")
public class AdTypeController {

    @Resource
    private AdTypeService adTypeService;

    /**
     * 所有推荐类别列表
     * @return
     */
    @GetMapping("list")
    public ResultData listAll() {
        List<AdType> list = adTypeService.list();
        return ResultData.ok().data("items", list);
    }

    /**
     * 推荐类别分页列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("list/{page}/{limit}")
    public ResultData listPage(@PathVariable Long page, @PathVariable Long limit) {
        Page<AdType> pageParam = new Page<>(page, limit);
        IPage<AdType> pageModel = adTypeService.page(pageParam);
        List<AdType> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return ResultData.ok().data("total", total).data("rows", records);
    }

    /**
     * 根据ID删除推荐类别
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public ResultData removeById(@PathVariable String id) {
        boolean result = adTypeService.removeById(id);
        if (result) {
            return ResultData.ok().message("删除成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 新增推荐类别
     * @param adType
     * @return
     */
    @PostMapping("save")
    public ResultData save(@RequestBody AdType adType) {
        boolean result = adTypeService.save(adType);
        if (result) {
            return ResultData.ok().message("保存成功");
        } else {
            return ResultData.error().message("保存失败");
        }
    }

    /**
     * 更新推荐类别
     * @param adType
     * @return
     */
    @PutMapping("update")
    public ResultData updateById(@RequestBody AdType adType) {
        boolean result = adTypeService.updateById(adType);
        if (result) {
            return ResultData.ok().message("修改成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }
    /**
     * 根据id获取推荐类别信息
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public ResultData getById(@PathVariable String id) {
        AdType adType = adTypeService.getById(id);
        if (adType != null) {
            return ResultData.ok().data("item", adType);
        } else {
            return ResultData.error().message("数据不存在");
        }
    }
}

