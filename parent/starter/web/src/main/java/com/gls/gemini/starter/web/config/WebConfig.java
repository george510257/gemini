package com.gls.gemini.starter.web.config;

import com.gls.gemini.starter.web.request.RequestBodyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web mvc 配置
 */
@Configuration
public class WebConfig {

    /**
     * 请求过滤器
     * 用于解决流只能读取一次的问题
     *
     * @return 请求过滤器
     */
    @Bean
    public FilterRegistrationBean<RequestBodyFilter> requestBodyFilterBean() {
        FilterRegistrationBean<RequestBodyFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RequestBodyFilter());
        registration.addUrlPatterns("/*");
        registration.setName("requestBodyFilter");
        registration.setOrder(Integer.MIN_VALUE);
        return registration;
    }
}
