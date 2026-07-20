package org.gls.gemini.framework.starter.core.model;

import lombok.Data;
import org.gls.gemini.framework.starter.core.contract.IDomain;

import java.util.Date;

/**
 * 基础VO
 */
@Data
public abstract class BaseVO implements IDomain {
    /**
     * 主键
     */
    private Long id;

    /**
     * 租户
     */
    private Long tenantId;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 删除标志
     */
    private Boolean deleted;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Long updateUserId;

    /**
     * 更新人名称
     */
    private String updateUserName;

    /**
     * 更新时间
     */
    private Date updateTime;
}
