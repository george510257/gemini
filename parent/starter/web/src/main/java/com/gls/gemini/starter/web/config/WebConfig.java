package com.gls.gemini.starter.web.config;

import cn.hutool.core.date.DatePattern;
import com.gls.gemini.starter.web.jackson.GeminiModule;
import com.gls.gemini.starter.web.request.RequestBodyFilter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * web配置
 */
@Configuration
public class WebConfig {
    /**
     * Jackson 配置
     *
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> builder.locale(Locale.CHINA)
                .timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
                .simpleDateFormat(DatePattern.NORM_DATETIME_PATTERN)
                .modules(new GeminiModule());
    }

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

    /**
     * 国际化配置
     *
     * @return 国际化配置
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        return messageSource;
    }
}
