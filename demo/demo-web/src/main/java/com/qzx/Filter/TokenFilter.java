package com.qzx.Filter;

import com.qzx.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        获取请求url
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login")){
            log.info("登录操作放行");
            filterChain.doFilter(request,response);
            return;
        }

//        获取请求头的Token
        String token = request.getHeader("Token");
        if (token == null || token.isEmpty()){
            log.info("没有携带token返回401");
            response.setStatus(401);
            return;
        }
        try {
            Claims claims = JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("token错误");
            response.setStatus(401);
            return;
        }
        filterChain.doFilter(request,response);
    }
}
