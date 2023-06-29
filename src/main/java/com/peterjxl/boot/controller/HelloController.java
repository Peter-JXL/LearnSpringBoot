package com.peterjxl.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @Controller + @ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "你好, Spring Boot 2!";
    }
}
