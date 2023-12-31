package com.peterjxl.boot.controller;


import com.peterjxl.boot.bean.Person2;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {


    @PostMapping("/saveUser")
    public Person2 saveUser(Person2 person2) {
        return person2;
    }

    @GetMapping("/car/{id}/owner/{username}")   //REST风格
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", name);
        map.put("pv", pv);
        return map;
    }

    @GetMapping("/testRequestHeader")
    public Map<String, Object> testRequestHeader(@RequestHeader("User-Agent") String userAgent,
                                                 @RequestHeader Map<String, String> headerMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("User-Agent", userAgent);
        map.put("headerMap", headerMap);
        return map;
    }

    @GetMapping("/testRequestParam")
    public Map<String, Object> testRequestParam(@RequestParam("age") Integer age,
                                                @RequestParam("inters") List<String> inters,
                                                @RequestParam Map<String, String> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);  //所有参数
        return map;
    }

    @GetMapping("/testCookieValue")
    public Map<String, Object> testCookieValue(@CookieValue("Hm_lpvt_935c298d3de674300e25695d1ece4c34") String c,
                                               @CookieValue("Hm_lpvt_935c298d3de674300e25695d1ece4c34") Cookie cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("c", c);
        System.out.println(cookie.getName() + "----" + cookie.getValue());
        return map;
    }

    @PostMapping("/testRequestBody")
    public Map<String, Object> testRequestBody(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    //  请求路径：/cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String > brand,
                                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
