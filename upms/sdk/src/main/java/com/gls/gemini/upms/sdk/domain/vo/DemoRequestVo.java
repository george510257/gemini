package com.gls.gemini.upms.sdk.domain.vo;

import com.gls.gemini.sdk.core.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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

    private LocalDateTime localDate;
}
