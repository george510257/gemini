package com.gls.gemini.starter.web.result;

import com.gls.gemini.common.bean.constants.CommonConstants;
import com.gls.gemini.common.bean.domain.BaseProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 忽略配置
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = CommonConstants.PROPERTIES_PREFIX + ".web.result")
public class ResultProperties extends BaseProperties {
    /**
     * 忽略的返回类型
     */
    private List<Class<?>> ignoreReturnTypes = new ArrayList<>();
    /**
     * 忽略的转换类型
     */
    private List<Class<?>> ignoreConverterTypes = new ArrayList<>();
}
