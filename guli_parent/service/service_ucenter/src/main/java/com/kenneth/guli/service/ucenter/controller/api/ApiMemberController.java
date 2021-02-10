package com.kenneth.guli.service.ucenter.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.ucenter.service.MemberService;
import com.kenneth.guli.service.ucenter.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Zyh
 * @Date: 2021/2/10 12:20
 * @Version: 1.0
 * 会员管理
 */

@CrossOrigin
@RestController
@RequestMapping("/api/ucenter/member")
@Slf4j
public class ApiMemberController {


    @Resource
    private MemberService memberService;

    /**
     * 会员注册
     * @param registerVo
     * @return
     */
    @PostMapping("register")
    public ResultData register(@RequestBody RegisterVo registerVo){
        memberService.register(registerVo);
        return ResultData.ok();
    }
}
