package com.qzx.utils;

import com.qzx.pojo.vxRsult;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpCli {
    public static vxRsult doGet(String url, Map<String, String> map)  {
        StringBuilder sb = new StringBuilder(url);
        boolean first = true; // 标记是否是第一个参数

        for (String key : map.keySet()) {
            if (first) {
                sb.append("?"); // 第一个参数前加 "?"
                first = false;
            } else {
                sb.append("&"); // 非第一个参数前加 "&"
            }
            // 对 key 和 value 进行 URL 编码
            try {
                sb.append(URLEncoder.encode(key, "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(map.get(key), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sb.toString());
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String string = EntityUtils.toString(entity);
            JSONObject jsonObject = new JSONObject(string);
            String openid = jsonObject.getString("openid");
            String sessionKey = jsonObject.getString("session_key");
            vxRsult vxUser = new vxRsult();
            vxUser.setOpenid(openid);
            vxUser.setSessionKey(sessionKey);
            execute.close();
            httpClient.close();
            return vxUser;
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
