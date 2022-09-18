package com.chnherb.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.chnherb.boot.bean.Car;
import com.chnherb.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 1. 配置类里面使用 @Bean 标注在方法上给容器注册组件，默认是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods: 代理 bean 的方法
 *      Full(proxyBeanMethods = true, 默认)
 *      Lite(proxyBeanMethods = false)
 */

@EnableConfigurationProperties(Car.class)
/**
 * 1.开启 Car 配置绑定功能
 * 2.将 Car 组件自动注入到容器中
 */

@Import({User.class, DBHelper.class})
// 加载 xml 配置文件
@ImportResource(locations = "classpath:bean.xml")
@Configuration(proxyBeanMethods = true) // 声明这是一个配置类 = 配置文件
public class BeanConfig {

    @Bean // 默认以方法名为 id 注册组件
    public User user02() {
        return new User(1002, "lisi", 22);
    }
}
