package com.study.springboot.service;

import com.study.springboot.event.UserLoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CouponService {

    @Async   // 异步，多线程执行
    @EventListener(UserLoginSuccessEvent.class)
    public void sendCouponEventListener(UserLoginSuccessEvent event) {
        log.info("事件监听 ==> 优惠券服务监听到用户【{}】登录事件", event.getUsername());
        String username = event.getUsername();
        getCoupon(username);
    }


    public void getCoupon(String username) {
        log.info("用户【{}】领取优惠券", username);
    }
}
