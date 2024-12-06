package com.robot.xxx.robot.service.impl;

import com.robot.xxx.robot.bean.Robot;
import com.robot.xxx.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;

public class RobotServiceImpl implements RobotService {

    @Autowired
    private Robot robot;

    @Override
    public String talk(String msg) {
        robot.setTalkMsg(msg);
        return robot.toString();
    }
}
