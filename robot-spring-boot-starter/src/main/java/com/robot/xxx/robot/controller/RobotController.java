package com.robot.xxx.robot.controller;

import com.robot.xxx.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/aiRobot")
public class RobotController {

    @Autowired
    private RobotService robotService;

    @RequestMapping("/talk")
    public String talk(@RequestParam("msg") String msg) {
        return robotService.talk(msg);
    }
}
