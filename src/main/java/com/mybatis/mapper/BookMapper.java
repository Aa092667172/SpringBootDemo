package com.mybatis.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    @Insert("insert into book(name) values(#{name})")
    void insert(String name);
}
