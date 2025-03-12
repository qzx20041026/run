package com.qzx;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class DemoWebApplicationTests {

    @Test
    void contextLoads() throws IOException {
//        CloseableHttpClient aDefault = HttpClients.createDefault();
//
////        创建请求对象
//        HttpGet httpGet = new HttpGet("");
//
////        发送请求接受响应结果
//        CloseableHttpResponse execute = aDefault.execute(httpGet);
//        HttpEntity entity = execute.getEntity();
//        String string = EntityUtils.toString(entity);
//        System.out.println("" + string);
//
//        execute.close();
//        aDefault.close();
    }
public static void main(String[] args) {
    Map<String, Object> map = new HashMap<>();
    map.put("appid","");
    map.put("secret","");
    map.put("js_code","");
    for (String s : map.keySet())
        System.out.println(s);
}
}
