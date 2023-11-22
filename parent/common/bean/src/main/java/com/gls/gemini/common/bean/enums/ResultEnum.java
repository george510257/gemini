package com.gls.gemini.common.bean.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultEnum implements BaseEnum {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAILED(500, "失败"),
    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),
    /**
     * 未认证
     */
    UNAUTHORIZED(401, "未认证"),
    /**
     * 未授权
     */
    FORBIDDEN(403, "未授权"),
    /**
     * 未找到
     */
    NOT_FOUND(404, "未找到"),
    /**
     * 业务错误
     */
    BUSINESS_ERROR(1001, "业务错误"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(9999, "未知错误");

    /**
     * 枚举编码
     */
    private final Integer code;
    /**
     * 枚举信息
     */
    private final String message;
}
