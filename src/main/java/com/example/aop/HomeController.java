package com.example.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenpeng
 * @date : 2018-07-25 10:03
 * @RestController 相当于  @RequestBody + @Controller  以json字符串格式返回
 */
@RestController
@RequestMapping("/demo1")
public class HomeController {

    @RequestMapping("/add1")
    public String add1(String name) {
        return "Success";
    }

    @RequestMapping("/add2")
    public String add2(String name) {
        return "Success";
    }

    @RequestMapping("/add3")
    public String add3(String name) {
        return "Success";
    }

}
