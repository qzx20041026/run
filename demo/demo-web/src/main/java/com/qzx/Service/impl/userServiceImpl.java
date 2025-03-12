package com.qzx.Service.impl;

import com.qzx.Mapper.userMapper;
import com.qzx.Service.userService;
import com.qzx.pojo.User;
import com.qzx.pojo.vxRsult;
import com.qzx.pojo.vxUser;
import com.qzx.pojo.wxDto;
import com.qzx.utils.HttpCli;
import com.qzx.utils.JwtUtils;
import com.qzx.utils.WeChatDecryptor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private wxDto wxDto;
    @Autowired
    private userMapper userMapper;

    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        Map<String,Object>map =new HashMap<>();
        map.put("userId",login.getUserId());
        map.put("userName",login.getUserName());
        String s = JwtUtils.generateToken(map);
        login.setToken(s);
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

    @Override
    public User loginwx(vxUser code) {
        Map<String,String> map=new HashMap<>();
        map.put("js_code",code.getCode());
        map.put("appid",wxDto.getAppid());
        map.put("secret",wxDto.getAppsecret());
        map.put("grant_type","authorization_code");
//       发送请求获取JSON数据
        vxRsult vxRsult = HttpCli.doGet("https://api.weixin.qq.com/sns/jscode2session", map);
        User user = userMapper.byOpenid(vxRsult.getOpenid());
        String s = WeChatDecryptor.decryptPhoneNumber(code.getEncryptedData(), code.getIv(), vxRsult.getSessionKey());
        if(user == null){
            User u=new User();
            u.setUserName(s.substring(7,11));
            u.setPassword("123456");
            u.setPhone(s);
            u.setOpenid(vxRsult.getOpenid());
            u.setCreatedTime(LocalDateTime.now());
            u.setUpdatedTime(LocalDateTime.now());
            userMapper.sign(u);
            user = u;
        }else{
            user.setOpenid(vxRsult.getOpenid());
            userMapper.update(user);
        }
        Map<String,Object>map1 =new HashMap<>();
        map1.put("userId",user.getUserId());
        map1.put("userName",user.getUserName());
        user.setToken(JwtUtils.generateToken(map1));
        return user;
    }

}
