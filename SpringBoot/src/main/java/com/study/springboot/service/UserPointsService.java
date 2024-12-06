package com.study.springboot.service;

import com.study.springboot.event.UserLoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserPointsService {

    @Async
    @EventListener(UserLoginSuccessEvent.class)
    public void addPointsEventListener(UserLoginSuccessEvent event) {
        log.info("事件监听 ==> 用户【{}】登录成功，开始赠送积分", event.getUsername());
        String username = event.getUsername();
        addPoints(username);
    }

    public void addPoints(String username) {
        log.info("用户【{}】获赠积分", username);
    }
}
