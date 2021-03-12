package com.kenneth.guli.service.trade.feign.fallback;

import com.kenneth.guli.service.base.dto.MemberDto;
import com.kenneth.guli.service.trade.feign.UcenterMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 15:27
 * @Version: 1.0
 */
@Service
@Slf4j
public class UcenterMemberServiceFallBack implements UcenterMemberService {
    @Override
    public MemberDto getMemberDtoByMemberId(String memberId) {
        log.info("熔断保护");
        return null;
    }
}