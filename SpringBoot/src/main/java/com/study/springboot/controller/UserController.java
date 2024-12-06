package com.study.springboot.controller;

import com.study.springboot.event.UserLoginSuccessEvent;
import com.study.springboot.service.CouponService;
import com.study.springboot.service.UserPointsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/userBusiness")
public class UserController {

    // 同步阻塞式
    @Autowired
    private UserPointsService userPointsService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private ApplicationEventPublisher publisher;   // 应用事件发布器

    @GetMapping("/login")
    public String login() {
        // 1、用户登录
        log.info("用户登录");
//        // 2、用户积分加积分
//        userPointsService.addPoints("naruto");
//        // 3、用户领取优惠券
//        couponService.getCoupon("naruto");

        // 创建要发布的事件对象
        UserLoginSuccessEvent userLoginSuccessEvent = new UserLoginSuccessEvent("Naruto-V");
        // 发布事件
        publisher.publishEvent(userLoginSuccessEvent);
        // 返回结果
        return "登录成功";
    }
}
