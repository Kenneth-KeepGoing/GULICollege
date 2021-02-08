package com.kenneth.guli.service.cms.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.cms.entity.Ad;
import com.kenneth.guli.service.cms.service.AdService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ApiAdController
 * @Author zengyihang
 * @Date: 2021-02-08 10:28
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/api/cms/ad")
public class ApiAdController {

    @Resource
    private AdService adService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 根据推荐位id显示广告推荐
     * @param adTypeId
     * @return
     */
    @GetMapping("list/{adTypeId}")
    public ResultData listByAdTypeId( @PathVariable String adTypeId) {

        List<Ad> ads = adService.selectByAdTypeId(adTypeId);
        return ResultData.ok().data("items", ads);
    }

    /**
     * redis测试
     * @param ad
     * @return
     */
    @PostMapping("save-test")
    public ResultData saveAd(@RequestBody Ad ad){
        redisTemplate.opsForValue().set("index::ad", ad);
        return ResultData.ok();
    }

    /**
     * redis测试
     * @param key
     * @return
     */
    @GetMapping("get-test/{key}")
    public ResultData getAd(@PathVariable String key){
        Ad ad = (Ad)redisTemplate.opsForValue().get(key);
        return ResultData.ok().data("ad", ad);
    }

    /**
     * redis测试
     * @param key
     * @return
     */
    @DeleteMapping("remove-test/{key}")
    public ResultData removeAd(@PathVariable String key){
        Boolean delete = redisTemplate.delete(key);
        System.out.println(delete);//是否删除成功
        Boolean hasKey = redisTemplate.hasKey(key);
        System.out.println(hasKey);//key是否存在
        return ResultData.ok();
    }
}
