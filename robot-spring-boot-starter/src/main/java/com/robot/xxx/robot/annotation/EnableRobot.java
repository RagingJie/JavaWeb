package com.robot.xxx.robot.annotation;

import com.robot.xxx.robot.config.RobotConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RobotConfig.class)
public @interface EnableRobot {
}
