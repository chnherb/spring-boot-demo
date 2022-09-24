package com.chnherb.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false) // 没有依赖可以配置成 false
public class WebConfig
//        implements WebMvcConfigurer
{

    // 自定义修改 rest methodParam
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_method");
//        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    // 开启矩阵变量
    @Bean // 1、注入 WebMvcConfigurer
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false); // 不移除分号后面的内容
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }

//    // 2、实现 WebMvcConfigurer
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false); // 不移除分号后面的内容
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
