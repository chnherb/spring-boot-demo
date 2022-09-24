package com.chnherb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // 测试 REST
    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {
        return "GET-USER";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "POST-USER";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser() {
        return "PUT-USER";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String delUser() {
        return "DELETE-USER";
    }
}
