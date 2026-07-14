package org.gls.gemini.framework.starter.core.properties;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础属性类
 */
@Data
public class BaseProperties implements Serializable {

    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * 扩展属性
     */
    private Map<String, Object> extensions = new HashMap<>();
}
