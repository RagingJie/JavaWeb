package com.study.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

@Slf4j
public class MyListener implements SpringApplicationRunListener {

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
//        log.info("MyListener......starting....");
        System.out.println("MyListener......starting....");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("MyListener......started....");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("MyListener......ready....");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("MyListener......failed....");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        log.info("MyListener......environmentPrepared....");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("MyListener......contextPrepared....");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("MyListener......contextLoaded....");
    }
}
