package com.chnherb.boot.converter;


import com.chnherb.boot.bean.Car;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class HerbConverter implements HttpMessageConverter<Car> {
    // @ResponseBody 能读能写，这里不关注读功能，都为 false
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Car.class);
    }

    // 服务器统计所有 MessageConverter 支持的媒体类型
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-herb");
    }

    @Override
    public Car read(Class<? extends Car> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Car car, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义协议数据的写
        String data = "yyds: " + car.getBrand() + "; " + car.getPrice();
        // 写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }

}
