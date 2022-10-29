package com.chnherb.boot.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    // http://localhost:8888/actuator/health 可以查看到 myCom
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> infos = new HashMap<String, Object>();
        // 建立连接判断是否监控
        if (0 == 0) {
//            builder.up();
            builder.status(Status.UP);
            infos.put("code", "200");
            infos.put("msg", "xxx");
        } else {
//            builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            infos.put("code", "500");
            infos.put("msg", "this is error!!!");
        }
        builder.withDetail("ms", 300).withDetails(infos);
    }
}
