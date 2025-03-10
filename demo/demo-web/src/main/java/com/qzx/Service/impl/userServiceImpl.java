package com.qzx.Service.impl;
import com.qzx.Mapper.userMapper;
import com.qzx.Service.userService;
import com.qzx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;
    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        return login;
    }

    @Override
    public User byUserName(String userName) {
        return userMapper.byUserName(userName);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int sign(User user) {
        user.setCreatedTime(LocalDateTime.now());
        int sign = userMapper.sign(user);
        return sign;
    }

    @Override
    public int update(User user) {
        user.setUpdatedTime(LocalDateTime.now());
        int i = userMapper.update(user);
        return i;
    }
}
