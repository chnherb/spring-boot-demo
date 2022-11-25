package com.chnherb.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
@ConfigurationProperties("animal")
@Data
public class Dog implements Animal {
    private String name;
    private Integer age;
}
