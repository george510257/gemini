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

    /**
     * 初始化
     *
     * @throws ServletException Servlet异常
     */
    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        log.info("RequestBodyFilter init");
    }

    /**
     * 过滤器处理
     *
     * @param request     请求
     * @param response    响应
     * @param filterChain 过滤器链
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("RequestBodyFilter: {}", request.getContentType());
        // 如果是 json 请求，则包装一下
        if (request.getContentType() != null && request.getContentType().contains("application/json")) {
            filterChain.doFilter(new RequestBodyWrapper(request), response);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
