package com.chnherb.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = {"/css/*", "/images/*"})  // * 是servlet的写法，** 是spring的写法
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("MyFilter destroy");
    }
}
