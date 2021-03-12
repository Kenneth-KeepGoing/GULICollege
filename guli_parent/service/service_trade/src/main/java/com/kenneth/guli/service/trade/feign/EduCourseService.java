package com.kenneth.guli.service.trade.feign;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.service.base.dto.CourseDto;
import com.kenneth.guli.service.trade.feign.fallback.EduCourseServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 15:25
 * @Version: 1.0
 */
@Service
@FeignClient(value = "service-edu", fallback = EduCourseServiceFallBack.class)
public interface EduCourseService {
    @GetMapping(value = "/api/edu/course/inner/get-course-dto/{courseId}")
    CourseDto getCourseDtoById(@PathVariable(value = "courseId") String courseId);

    @GetMapping("/api/edu/course/inner/update-buy-count/{id}")
    ResultData updateBuyCountById(@PathVariable("id") String id);
}
