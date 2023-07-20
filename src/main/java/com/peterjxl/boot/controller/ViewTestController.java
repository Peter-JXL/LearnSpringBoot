package com.peterjxl.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/atguigu")
    public String atguigu(Model model){
        // model中的数据会被放在请求域中，相当于 request.setAttribute("msg", "hello, peterjxl!");
        model.addAttribute("msg", "hello, peterjxl!");
        model.addAttribute("link", "https://www.peterjxl.com");
        // 会被视图解析器处理，相当于 return thymeleaf/success.html;
        return "success";
    }
}
