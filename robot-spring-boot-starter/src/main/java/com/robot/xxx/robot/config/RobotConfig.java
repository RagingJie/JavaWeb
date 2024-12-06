package com.robot.xxx.robot.config;

import com.robot.xxx.robot.bean.Robot;
import com.robot.xxx.robot.controller.RobotController;
import com.robot.xxx.robot.service.RobotService;
import com.robot.xxx.robot.service.impl.RobotServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(Robot.class)
@Configuration
public class RobotConfig {

    @Bean
    public RobotService robotService() {
        return new RobotServiceImpl();
    }

    @Bean
    public RobotController robotBean() {
        return new RobotController();
    }

    @Bean
    public Robot robot() {
        return new Robot();
    }
}
