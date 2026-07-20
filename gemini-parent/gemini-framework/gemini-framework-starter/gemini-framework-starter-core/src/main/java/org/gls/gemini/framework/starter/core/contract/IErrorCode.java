package org.gls.gemini.framework.starter.core.contract;

import java.io.Serializable;

/**
 * 错误码接口
 */
public interface IErrorCode extends Serializable {
    /**
     * 获取错误码
     */
    String getCode();

    /**
     * 获取错误码描述
     */
    String getMessage();
}
