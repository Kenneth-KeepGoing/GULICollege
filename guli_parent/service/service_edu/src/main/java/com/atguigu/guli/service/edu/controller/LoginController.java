package com.atguigu.guli.service.edu.controller;

import com.atguigu.guli.common.base.result.ResultData;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Author zengyihang
 * @Date: 2021-01-20 17:45
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    /**
     * 登录
     * @return ResultData
     */
    @PostMapping("login")
    public ResultData login(){
        return ResultData.ok().data("token","admin");
    }

    /**
     * 获取用户信息
     * @return ResultData
     */
    @GetMapping("info")
    public ResultData info() {
        return ResultData.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
    }

    /**
     * 退出
     * @return ResultData
     */
    @PostMapping("logout")
    public ResultData logout(){
        return ResultData.ok();
    }

}
