package com.peterjxl.boot.controller;

import com.peterjxl.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @Controller + @ResponseBody
public class HelloController {


    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }


    @RequestMapping("/hello")
    public String hello() {
        return "你好, Spring Boot 2!";
    }
}
