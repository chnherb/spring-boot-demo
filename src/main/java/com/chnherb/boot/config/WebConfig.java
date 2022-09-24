package com.chnherb.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration(proxyBeanMethods = false) // 没有依赖可以配置成 false
public class WebConfig {

    // 自定义修改 rest methodParam
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_method");
//        methodFilter.setMethodParam("_m");
        return methodFilter;
    }
}
