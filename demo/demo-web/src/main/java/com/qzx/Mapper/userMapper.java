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

@Insert("insert into users(userName,image,password,phone,dormitoryBuilding,dormitoryRoom,createdTime,openid) values(#{userName},#{image},#{password},#{phone},#{dormitoryBuilding},#{dormitoryRoom},#{createdTime},#{openid})")
    int sign(User user);
    int update(User user);
@Select("select * from users where openid=#{openid}")
    User byOpenid(String openid);
}


