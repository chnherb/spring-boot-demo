package com.chnherb.boot.controller;

import com.chnherb.boot.bean.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

    @ResponseBody
    @GetMapping("getCar")
    public Car getCar() {
        Car car = new Car();
        car.setBrand("byd");
        car.setPrice(210000);
        return car;
    }
}
