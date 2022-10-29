package com.chnherb.boot.service;

import com.chnherb.boot.bean.People;
import com.chnherb.boot.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    public People getPeopleByID(Long id) {
        return peopleMapper.getByID(id);
    }
}
