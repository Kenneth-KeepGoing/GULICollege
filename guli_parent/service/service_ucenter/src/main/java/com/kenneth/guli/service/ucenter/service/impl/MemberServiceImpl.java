package com.kenneth.guli.service.ucenter.service.impl;

import com.kenneth.guli.service.ucenter.entity.Member;
import com.kenneth.guli.service.ucenter.mapper.MemberMapper;
import com.kenneth.guli.service.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Kenneth
 * @since 2021-02-10
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
