package com.gls.gemini.common.bean.enums;

/**
 * 枚举基类
 */
public interface BaseEnum {
    /**
     * 获取枚举编码
     *
     * @return 枚举编码
     */
    Integer getCode();

    /**
     * 获取枚举信息
     *
     * @return 枚举信息
     */
    String getMessage();
}
