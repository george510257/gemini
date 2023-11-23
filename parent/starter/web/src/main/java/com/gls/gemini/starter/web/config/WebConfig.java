package com.gls.gemini.starter.web.config;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.gls.gemini.starter.web.request.RequestBodyFilter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class WebConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> builder.locale(Locale.CHINA)
                .timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
                .simpleDateFormat(DatePattern.NORM_DATETIME_PATTERN)
                .serializerByType(Long.class, ToStringSerializer.instance)
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DatePattern.NORM_DATETIME_FORMATTER))
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DatePattern.NORM_DATETIME_FORMATTER))
                .modules(new JavaTimeModule());
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
}
