package com.robot.xxx.robot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "robot")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Robot implements Serializable {

    private static final long serialVersionUID = 324256346894L;

    // 名字
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private String sex;
    // 说话内容
    private String talkMsg;
    // 版本
    private String version;

}
