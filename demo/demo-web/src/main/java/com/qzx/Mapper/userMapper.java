package com.qzx.Mapper;

import com.qzx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userMapper {
    @Select("select * from users where userName=#{userName} and password=#{password}")
    User login(User user);
@Select("select * from users where userName=#{userName}")
    User byUserName(String userName);

@Insert("insert into users(userName,image,password,phone,dormitoryBuilding,dormitoryRoom,createdTime) values(#{userName},#{image},#{password},#{phone},#{dormitoryBuilding},#{dormitoryRoom},#{createdTime})")
    int sign(User user);
@Update("update users set phone=#{phone},dormitoryBuilding = #{dormitoryBuilding} , dormitoryRoom=#{dormitoryRoom},password=#{password},users.updatedTime=#{updatedTime} , image=#{image} where userId =#{userId}")
    int update(User user);
}
