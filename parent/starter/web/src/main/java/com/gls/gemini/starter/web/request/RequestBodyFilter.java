package com.gls.gemini.starter.web.request;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Request 包装类 过滤器
 */
@Slf4j
public class RequestBodyFilter extends OncePerRequestFilter {

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        log.info("RequestBodyFilter init");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("RequestBodyFilter: {}", request.getContentType());
        if (request.getContentType() != null && request.getContentType().contains("application/json")) {
            filterChain.doFilter(new RequestBodyWrapper(request), response);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
