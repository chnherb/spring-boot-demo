package com.chnherb.boot.config;

import com.chnherb.boot.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
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

            // 自定义类型转换器，用作请求参数转换
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Car>() {
                    @Override
                    public Car convert(String source) {
                        // byd,200000
                        if (StringUtils.isEmpty(source)) {
                            return null;
                        }
                        String[] split = source.split(",");
                        if (split.length != 2) {
                            return null;
                        }
                        Car car = new Car();
                        car.setBrand(split[0]);
                        car.setPrice(Integer.parseInt(split[1]));
                        return car;
                    }
                });
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
