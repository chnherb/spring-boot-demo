package com.chnherb.boot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 1、(proxyBeanMethods = true) （默认）保证依赖的 bean 始终是单实例，否则功能没有问题但会有性能问题
 * 2、/my 等路径直接被 servlet 响应，没有被 spring 拦截？（原理问题）
 */
@Configuration
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/my", "/my2");
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
//        // 第一种写法：配置拦截 servlet
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter, myServlet());
        // 第二种写法：自定义 urlPatterns
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/images/*"));
                return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener() {
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}
