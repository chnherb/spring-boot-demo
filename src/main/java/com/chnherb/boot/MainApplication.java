package com.chnherb.boot;

import ch.qos.logback.core.db.DBHelper;
import com.chnherb.boot.bean.User;
import com.chnherb.boot.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class, args);
        // 1. 返回 IOC 容器
        ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

        // 2. 查看容器里面的组件
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3. 从容器中获取组件
        User shangsan = (User) ctx.getBean("user01", User.class);
        User lisi = (User) ctx.getBean("user02", User.class);
        User lisi2 = (User) ctx.getBean("user02", User.class);
        System.out.println("zhangsan==lisi:" + (shangsan == lisi));
        System.out.println("lisi==lisi2:" + (lisi == lisi2));

        // 验证 @Configuration proxyBeanMethods 属性
        BeanConfig config = ctx.getBean(BeanConfig.class);
        // proxyBeanMethods=true: config:com.chnherb.boot.config.BeanConfig$$EnhancerBySpringCGLIB$$ea4bb2e5@12365c88
        // proxyBeanMethods=false: config:com.chnherb.boot.config.BeanConfig@130a0f66
        System.out.println("config:" + config);
        User userA = config.user02();
        User userB = config.user02();
        System.out.println("userA==userB:" + (userA == userB));

        // 5. 获取组件
        String[] beanNamesForType = ctx.getBeanNamesForType(User.class);
        System.out.println("beanNamesForType====");
        for (String s: beanNamesForType) {
            System.out.println(s);
        }
        DBHelper dbHelper = ctx.getBean(DBHelper.class);
        System.out.println(dbHelper); // id 为全类名

    }
}
