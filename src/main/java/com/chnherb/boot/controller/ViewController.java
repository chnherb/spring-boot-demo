package com.chnherb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/thyinfo")
    public String thyInfo(Model model) {
        // model 中的数据会被放在请求域中 request.setAttribute("msg", aa)
        model.addAttribute("msg", "hello thyinfo");
        return "thyinfo";
    }
}
