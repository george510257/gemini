package com.gls.gemini.upms.sdk.domain.vo;

import com.gls.gemini.sdk.core.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * demo响应vo
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DemoResponseVo extends BaseVo {
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 注册时间
     */
    private LocalDateTime registerTime = LocalDateTime.now();
}
