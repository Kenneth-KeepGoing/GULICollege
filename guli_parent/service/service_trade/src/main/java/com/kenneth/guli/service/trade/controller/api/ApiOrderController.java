package com.kenneth.guli.service.trade.controller.api;

import com.kenneth.guli.common.base.result.ResultData;
import com.kenneth.guli.common.base.util.JwtInfo;
import com.kenneth.guli.common.base.util.JwtUtils;
import com.kenneth.guli.service.trade.entity.Order;
import com.kenneth.guli.service.trade.feign.EduCourseService;
import com.kenneth.guli.service.trade.service.OrderService;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Zyh
 * @Date: 2021/3/12 15:27
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/trade/order")
@CrossOrigin //跨域
@Slf4j
public class ApiOrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private EduCourseService eduCourseService;

    /**
     * 新增订单
     * @param courseId
     * @param request
     * @return
     */
    @PostMapping("auth/save/{courseId}")
    public ResultData save(@PathVariable String courseId, HttpServletRequest request) {

        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        String orderId = orderService.saveOrder(courseId, jwtInfo.getId());
        return ResultData.ok().data("orderId", orderId);
    }

    /**
     * 获取订单
     * @param orderId
     * @param request
     * @return
     */
    @GetMapping("auth/get/{orderId}")
    public ResultData get(@PathVariable String orderId, HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        Order order = orderService.getByOrderId(orderId, jwtInfo.getId());
        return ResultData.ok().data("item", order);
    }

    /**
     * 判断课程是否购买
     * @param courseId
     * @param request
     * @return
     */
    @GetMapping("auth/is-buy/{courseId}")
    public ResultData isBuyByCourseId(@PathVariable String courseId, HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        Boolean isBuy = orderService.isBuyByCourseId(courseId, jwtInfo.getId());
        return ResultData.ok().data("isBuy", isBuy);
    }

    /**
     * 获取当前用户订单列表
     * @param request
     * @return
     */
    @GetMapping("auth/list")
    public ResultData list(HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        List<Order> list = orderService.selectByMemberId(jwtInfo.getId());
        return ResultData.ok().data("items", list);
    }

    /**
     * 删除订单
     * @param orderId
     * @param request
     * @return
     */
    @DeleteMapping("auth/remove/{orderId}")
    public ResultData remove(@PathVariable String orderId, HttpServletRequest request) {
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        boolean result = orderService.removeById(orderId, jwtInfo.getId());
        if (result) {
            return ResultData.ok().message("删除成功");
        } else {
            return ResultData.error().message("数据不存在");
        }
    }

    /**
     * 模拟支付
     * @param orderId
     * @param request
     * @return
     */
    @PostMapping("auth/pay/{orderId}")
    public ResultData pay(@PathVariable String orderId, HttpServletRequest request){
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        Order order = orderService.getByOrderId(orderId, jwtInfo.getId());
        order.setStatus(1);
        boolean result = orderService.updateById(order);
        if (result) {
            eduCourseService.updateBuyCountById(orderId);
            return ResultData.ok().message("支付成功").data("item", order);
        } else {
            return ResultData.error().message("支付失败").data("item", order);
        }
    }
}