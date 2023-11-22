package com.gls.gemini.upms.sdk.domain.vo;

import com.gls.gemini.common.bean.domain.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * demo请求vo
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DemoRequestVo extends BaseVo {
    /**
     * 名称
     */
    private String name;
}
