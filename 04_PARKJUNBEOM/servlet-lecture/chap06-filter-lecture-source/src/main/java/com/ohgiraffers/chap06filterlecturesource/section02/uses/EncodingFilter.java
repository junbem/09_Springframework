package com.ohgiraffers.chap06filterlecturesource.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encodingType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encodingType");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Encoding Filter 동작");
        // POST 방식의 요청이 오면 문자셋을 설정하는 전처리 작업
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if("POST".equals(request.getMethod())) {
            servletRequest.setCharacterEncoding(encodingType);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
