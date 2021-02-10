package com.kenneth.guli.service.ucenter.service;

import com.kenneth.guli.service.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kenneth.guli.service.ucenter.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author Kenneth
 * @since 2021-02-10
 */
public interface MemberService extends IService<Member> {

    void register(RegisterVo registerVo);
}
