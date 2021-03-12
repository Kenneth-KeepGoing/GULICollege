package com.kenneth.guli.service.ucenter.controller.api;

import com.kenneth.guli.common.base.result.ResultCodeEnum;
import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.JwtInfo;
import com.kenneth.guli.common.base.util.JwtUtils;
import com.kenneth.guli.service.base.dto.MemberDto;
import com.kenneth.guli.service.base.exception.GuliException;
import com.kenneth.guli.service.ucenter.service.MemberService;
import com.kenneth.guli.service.ucenter.vo.LoginVo;
import com.kenneth.guli.service.ucenter.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    /**
     * 会员登录
     * @param loginVo
     * @return
     */
    @PostMapping("login")
    public ResultData login(@RequestBody LoginVo loginVo) {
        String token = memberService.login(loginVo);
        return ResultData.ok().data("token", token);
    }

    /**
     * 根据token获取登录信息
     * @param request
     * @return
     */
    @GetMapping("get-login-info")
    public ResultData getLoginInfo(HttpServletRequest request){

        try{
            JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
            return ResultData.ok().data("userInfo", jwtInfo);
        }catch (Exception e){
            log.error("解析用户信息失败，" + e.getMessage());
            throw new GuliException(ResultCodeEnum.FETCH_USERINFO_ERROR);
        }
    }

    /**
     * 根据会员id查询会员信息
     * @param memberId
     * @return
     */
    @GetMapping("inner/get-member-dto/{memberId}")
    public MemberDto getMemberDtoByMemberId(@PathVariable String memberId){
        MemberDto memberDto = memberService.getMemberDtoByMemberId(memberId);
        return memberDto;
    }
}
