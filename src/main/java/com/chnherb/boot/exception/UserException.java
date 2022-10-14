package com.chnherb.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 使用方法，直接在业务代码中判断并抛出该异常
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户错误")
public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(String msg) {
        super(msg);
    }
}
