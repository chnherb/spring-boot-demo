package com.chnherb.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
@ConfigurationProperties("animal")
@Data
public class Cat implements Animal {
    private String name;
    private Integer age;
}
