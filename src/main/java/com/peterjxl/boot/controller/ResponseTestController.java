package com.peterjxl.boot.controller;


import com.peterjxl.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setUserName("peterjxl");
        person.setAge(20);
        return person;
    }
}
