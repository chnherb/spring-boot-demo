package com.chnherb.boot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 不指定优先级轮询到 DefaultHandlerExceptionResolver 就直接返回了，走不到自定义的异常解析器
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class CustomerHanlderExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(600, "customer error");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
