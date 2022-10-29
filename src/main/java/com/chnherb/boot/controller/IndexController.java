package com.chnherb.boot.controller;

import com.chnherb.boot.bean.City;
import com.chnherb.boot.bean.People;
import com.chnherb.boot.service.CityService;
import com.chnherb.boot.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PeopleService peopleService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/sql")
    public Long queryFromDb() {
        Long count = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return count;
    }

    @ResponseBody
    @GetMapping("/people")
    public People getPeopleByID(@RequestParam("id") Long id) {
        return peopleService.getPeopleByID(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityByID(@RequestParam("id") Long id) {
        return cityService.getCityByID(id);
    }

    // curl -d 'name=beijng&country=中国' -X POST "http://127.0.0.1:8888/city"
    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }
}
