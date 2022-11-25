package com.chnherb.boot.config;

import com.chnherb.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
    @Profile("prod")
    @Bean
    public Color green() {
        return new Color("green");
    }

    @Profile("test")
    @Bean
    public Color red() {
        return new Color("red");
    }
}
