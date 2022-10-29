package com.chnherb.boot.mapper;

import com.chnherb.boot.bean.People;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

//@MapperScan("com.chnherb.boot.mapper")
@Mapper
public interface PeopleMapper {
    public People getByID(Long id);
}
