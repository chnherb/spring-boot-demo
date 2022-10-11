package com.chnherb.boot.controller;

import com.chnherb.boot.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormController {
    final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @GetMapping("/profile")
    public String profile() {
        return "form/profile";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("header") MultipartFile header,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
        if (!header.isEmpty()) {
            String originFilename = header.getOriginalFilename();
            header.transferTo(new File("/Users/bo/code/spring-boot-demo/" + originFilename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("/Users/bo/code/spring-boot-demo/" + originFilename));
                }
            }
        }
        return "upload success";
    }
}
