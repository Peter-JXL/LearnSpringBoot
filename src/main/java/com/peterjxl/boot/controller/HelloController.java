package com.peterjxl.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @Controller + @ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot 2!";
    }
}
