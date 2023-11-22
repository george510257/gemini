package com.gls.gemini.starter.web;

import com.gls.gemini.starter.web.properties.ResultProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableConfigurationProperties({ResultProperties.class})
public class WebAutoConfig {
}
