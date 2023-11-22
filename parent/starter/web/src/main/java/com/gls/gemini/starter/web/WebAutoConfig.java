package com.gls.gemini.starter.web;

import com.gls.gemini.starter.web.result.ResultProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 核心自动配置
 */
@Configuration
@ComponentScan
@EnableConfigurationProperties({ResultProperties.class})
public class WebAutoConfig {
}
