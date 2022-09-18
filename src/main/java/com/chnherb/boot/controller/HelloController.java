package com.chnherb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
// RestController = ResponseBody + Controller
@RestController
public class HelloController {

    // 可以直接配置在类上
    // @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
