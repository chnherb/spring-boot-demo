package com.chnherb.boot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myservice")
public class MyServiceEndpoint {
    // 端点的读操作：访问 /actuator/myservice 可得到该信息
    @ReadOperation
    public Map myServiceInfo() {
        return Collections.singletonMap("serviceInfo", "serviceInfo: say hello");
    }

    @WriteOperation
    public void stopMyService() {
        System.out.println("my service stopped...");
    }
}
