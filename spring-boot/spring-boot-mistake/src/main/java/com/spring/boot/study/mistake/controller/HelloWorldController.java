package com.spring.boot.study.mistake.controller;

import com.spring.boot.study.mistake.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private UserService userService;

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "hello world!";
    }
}
