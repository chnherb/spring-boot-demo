package com.chnherb.boot.service;

import com.chnherb.boot.bean.City;
import com.chnherb.boot.mapper.CityMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    Counter counter;

    public CityService(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("cityService.getCityByID.count"); //注册
    }

    public City getCityByID(Long id) {
        // 1. 访问 /actuator/metrics 可以发现多了一个 cityService.getCityByID.count 指标
        // 2. 访问 /actuator/metrics/cityService.getCityByID.count 可以看到 COUNT 为0
        // 3. 调用 /car?id=1，访问上一步的连接，可以看到 COUNT 数值
        counter.increment();
        return cityMapper.getByID(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
        System.out.println(city);
    }
}
