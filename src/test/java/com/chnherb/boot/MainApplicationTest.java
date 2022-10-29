package com.chnherb.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class MainApplicationTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
//        jdbcTemplate.queryForObject("select * from user");
//        jdbcTemplate.queryForList("select * from user", )
        Long count = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("count: {}", count);
    }
}