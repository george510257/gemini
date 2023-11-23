package com.gls.gemini.starter.web.config;

import cn.hutool.core.date.DatePattern;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * web mvc 配置
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;


    /**
     * 添加日期格式化
     *
     * @param registry 注册器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DatePattern.NORM_DATE_FORMATTER);
        registrar.setTimeFormatter(DatePattern.NORM_TIME_FORMATTER);
        registrar.setDateTimeFormatter(DatePattern.NORM_DATETIME_FORMATTER);
        registrar.registerFormatters(registry);
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 移除默认的 jackson 转换器
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof AbstractJackson2HttpMessageConverter);
        // 添加自定义的 jackson 转换器
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setObjectMapper(jackson2ObjectMapperBuilder.build());
        converters.add(converter);
        converters.forEach(c -> log.info("converter: {}", c.getClass().getName()));
    }


}
