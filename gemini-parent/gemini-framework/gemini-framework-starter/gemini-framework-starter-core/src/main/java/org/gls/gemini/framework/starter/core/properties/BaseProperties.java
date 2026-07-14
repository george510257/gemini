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

    private boolean enabled = true;

    private Map<String, Object> extensions = new HashMap<>();
}
