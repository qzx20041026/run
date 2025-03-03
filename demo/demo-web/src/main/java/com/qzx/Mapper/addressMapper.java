package com.qzx.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface addressMapper {
    @Select("select * from addresses")
    List<Integer> list();
}
