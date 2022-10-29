package com.chnherb.boot.mapper;

import com.chnherb.boot.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("Select * from city where id=#{id}")
    public City getByID(Long id);

    @Insert("insert into City(`name`, `country`) values (#{name}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);
}
