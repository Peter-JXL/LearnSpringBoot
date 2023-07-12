package com.peterjxl.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了");
        request.setAttribute("code", 200);
        return "forward:/success";  //转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> testForward(@RequestAttribute("msg") String msg,
                           @RequestAttribute("code") Integer code,
                           HttpServletRequest request) {

        Map<String, Object> map = new java.util.HashMap<>();
        map.put("reqMethod_msg", msg);
        map.put("annotation_msg", request.getAttribute("msg"));
        return map;
    }
}
