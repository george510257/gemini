package org.gls.gemini.framework.starter.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private final String code;
    /**
     * 异常信息
     */
    private final String message;

    /**
     * 构造方法
     *
     * @param code    异常码
     * @param message 异常信息
     */
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
