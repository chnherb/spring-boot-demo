package com.chnherb.boot.exception;

import com.chnherb.boot.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String hanldeArithException(Exception e) {
        log.error("hanldeArithException error: {}", e);
        return ""; // 试图地址或ModelAndView
    }
}
