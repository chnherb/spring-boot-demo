package com.chnherb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("goto")
    public String gotoPage(HttpServletRequest request) {
        request.setAttribute("code", 301);
        request.setAttribute("msg", "this is msg");
        return "forward:success"; // 转发到 /success 请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("code") int code,
                                       @RequestAttribute("msg") String msg,
                                       HttpServletRequest request
    ) {
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        Map<String, Object> map = new HashMap<>();
        map.put("requestAttributeMsg", msg1);
        map.put("requestAttributeCode", code1);
        map.put("msg", msg);
        map.put("code", code);
        return map;
    }
}
