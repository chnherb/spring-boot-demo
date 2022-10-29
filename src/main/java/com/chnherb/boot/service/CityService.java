package com.chnherb.boot.service;

import com.chnherb.boot.bean.City;
import com.chnherb.boot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public City getCityByID(Long id) {
        return cityMapper.getByID(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
        System.out.println(city);
    }
}
