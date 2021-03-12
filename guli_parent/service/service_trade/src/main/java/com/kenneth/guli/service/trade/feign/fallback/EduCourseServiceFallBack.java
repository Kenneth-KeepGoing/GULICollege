package com.kenneth.guli.service.trade.feign.fallback;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.base.dto.CourseDto;
import com.kenneth.guli.service.trade.feign.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 15:25
 * @Version: 1.0
 */
@Service
@Slf4j
public class EduCourseServiceFallBack implements EduCourseService {
    @Override
    public CourseDto getCourseDtoById(String courseId) {
        log.info("熔断保护");
        return null;
    }
    @Override
    public ResultData updateBuyCountById(String id) {
        log.error("熔断器被执行");
        return ResultData.error();
    }
}
