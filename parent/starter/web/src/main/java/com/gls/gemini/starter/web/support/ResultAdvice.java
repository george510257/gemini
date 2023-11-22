package com.gls.gemini.starter.web.support;

import cn.hutool.json.JSONUtil;
import com.gls.gemini.common.bean.constants.CommonConstants;
import com.gls.gemini.common.bean.domain.Result;
import com.gls.gemini.common.bean.util.ResultUtil;
import com.gls.gemini.starter.web.properties.ResultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回值处理
 */
@Slf4j
@RestControllerAdvice(basePackages = CommonConstants.PACKAGE_PREFIX)
public class ResultAdvice implements ResponseBodyAdvice<Object> {

    private final ResultProperties resultProperties;

    public ResultAdvice(ResultProperties resultProperties) {
        this.resultProperties = resultProperties;
    }

    /**
     * 是否支持
     *
     * @param returnType    返回值类型
     * @param converterType 转换器类型
     * @return 是否支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("returnType:{}", returnType.getGenericParameterType().getClass().getSimpleName());
        log.info("converterType:{}", converterType.getSimpleName());
        if (resultProperties.isEnable()) {
            if (!resultProperties.getIgnoreReturnTypes().contains(returnType.getGenericParameterType().getClass())) {
                return true;
            }
            return !resultProperties.getIgnoreConverterTypes().contains(converterType);
        }
        return false;

    }

    /**
     * 返回值处理
     *
     * @param body                  返回值
     * @param returnType            返回值类型
     * @param selectedContentType   返回值类型
     * @param selectedConverterType 转换器类型
     * @param request               请求
     * @param response              响应
     * @return 处理后的返回值
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("body:{}", body);
        // 如果是feign调用，那么就直接返回
        if (request.getHeaders().containsKey(CommonConstants.HEADER_FEIGN_ID)) {
            return body;
        }
        // 如果是Result类型，那么就直接返回
        if (body instanceof Result) {
            return body;
        }
        // 如果是String类型
        if (body instanceof String str) {
            // 如果是JSON字符串 数组
            if (JSONUtil.isTypeJSONArray(str)) {
                return JSONUtil.toJsonStr(ResultUtil.success(JSONUtil.parseArray(str)));
            }
            // 如果是JSON字符串 对象
            if (JSONUtil.isTypeJSONObject(str)) {
                return JSONUtil.toJsonStr(ResultUtil.success(JSONUtil.parseObj(str)));
            }
            return body;
        }
        return ResultUtil.success(body);
    }
}
