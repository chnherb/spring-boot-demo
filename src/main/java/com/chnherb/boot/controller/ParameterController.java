package com.chnherb.boot.controller;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    // 请求：/user/1001/name/zhangsan?age=20&number=1234&interest=ball&interest=game
    @GetMapping("/user/{id}/name/{username}")
    public Map<String, Object> getUser(@PathVariable("id") Integer id,
                                       @PathVariable("username") String name,
                                       @PathVariable Map<String, String> pv, // PathVariable 注解注释中说明会将所有参数放入 Map 中
                                       @RequestHeader("User-Agent") String userAgent,
                                       @RequestHeader Map<String, String> header,
                                       @RequestParam("age") Integer age,
                                       @RequestParam("interest") List<String> interests,
                                       @RequestParam Map<String, String> params,
                                       @CookieValue("_ga") String _ga,
                                       @CookieValue("_ga") Cookie cookie

    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("header", header);
        map.put("age", age);
        map.put("interests", interests);
        map.put("params", params);
        map.put("_ga", _ga);
        map.put("cookie", cookie);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    // 1、语法：/cars/sell;low=23;brand=byd,audi,dazhong
    // 2、SpringBoot 默认关闭矩阵变量
    // 手动开启原理：
    // WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter 类中的 configurePathMatch 方法，
    // UrlPathHelper 中 removeSemicolonContent 变量默认 true，默认移除分号后的内容
    @GetMapping("cars/{path}") // 3、注意矩阵变量是绑定到路径变量中的，这里不能直接写成 cars/sell
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brands,
                                        @PathVariable("path") String path
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brands", brands);
        map.put("path", path);
        return map;
    }

    // /boss/2;age=20/3;age=30
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boos(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }

}
