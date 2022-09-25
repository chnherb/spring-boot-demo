package com.chnherb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("params")
    public String params(Map<String, Object> map,
                         Model model,
                         HttpServletRequest request,
                         HttpServletResponse response
    ) {
        map.put("test1", "haha1");
        model.addAttribute("test2", "haha2");
        request.setAttribute("test3", "haha3");
        Cookie cookie = new Cookie("test4", "haha4");
        response.addCookie(cookie);
        return "forward:/info";
    }

    @ResponseBody
    @GetMapping("/info")
    public Map info(@RequestAttribute(value = "msg", required = false) String msg,
                    HttpServletRequest request
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        Object test1 = request.getAttribute("test1");
        Object test2 = request.getAttribute("test2");
        Object test3 = request.getAttribute("test3");

        map.put("test1", test1);
        map.put("test2", test2);
        map.put("test3", test3);
        return map;
    }
}
