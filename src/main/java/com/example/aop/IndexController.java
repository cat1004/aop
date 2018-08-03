package com.example.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenpeng
 * @date : 2018-07-25 10:03
 */
@RestController
@RequestMapping("/demo2")
public class IndexController {
    @MyAnnotation
    @RequestMapping("/add1")
    public String add1(String name) {
        return "Success2";
    }

    @RequestMapping("/add2")
    public String add2(String name) {
        return "Success2";
    }

    @RequestMapping("/add3")
    public String add3(String name) {
        return "Success2";
    }

}
