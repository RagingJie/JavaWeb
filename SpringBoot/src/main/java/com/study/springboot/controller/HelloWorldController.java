package com.study.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@CrossOrigin
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world！";
    }
}
