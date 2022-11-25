package com.chnherb.boot.controller;

import com.chnherb.boot.bean.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @Value("${person.name:张三}")
    private String name;

    @Autowired
    private Animal animal;

    @RequestMapping("/haha")
    public String haha() {
        return "hahah: " + name;
    }

    @RequestMapping("/animal")
    public String animal() {
        return "animal: " + animal.getClass().getName();
    }

}
