package org.gls.gemini.framework.starter.core.contract;

import java.io.Serializable;
import java.util.Date;

/**
 * 域层接口
 */
public interface IDomain extends Serializable {
    /**
     * 获取领域对象的唯一标识符
     */
    Long getId();

    /**
     * 设置领域对象的唯一标识符
     */
    void setId(Long id);

    /**
     * 获取领域对象的租户id
     */
    Long getTenantId();

    /**
     * 设置领域对象的租户id
     */
    void setTenantId(Long tenantId);

    /**
     * 获取领域对象的版本号
     */
    Integer getVersion();

    /**
     * 设置领域对象的版本号
     */
    void setVersion(Integer version);

    /**
     * 获取领域对象的删除标志
     */
    Boolean getDeleted();

    /**
     * 设置领域对象的删除标志
     */
    void setDeleted(Boolean deleted);

    /**
     * 获取领域对象的创建人id
     */
    Long getCreateUserId();

    /**
     * 设置领域对象的创建人id
     */
    void setCreateUserId(Long createUserId);

    /**
     * 获取领域对象的创建人名称
     */
    String getCreateUserName();

    /**
     * 设置领域对象的创建人名称
     */
    void setCreateUserName(String createUserName);

    /**
     * 获取领域对象的创建时间
     */
    Date getCreateTime();

    /**
     * 设置领域对象的创建时间
     */
    void setCreateTime(Date createTime);

    /**
     * 获取领域对象的更新人id
     */
    Long getUpdateUserId();

    /**
     * 设置领域对象的更新人id
     */
    void setUpdateUserId(Long updateUserId);

    /**
     * 获取领域对象的更新人名称
     */
    String getUpdateUserName();

    /**
     * 设置领域对象的更新人名称
     */
    void setUpdateUserName(String updateUserName);

    /**
     * 获取领域对象的更新时间
     */
    Date getUpdateTime();

    /**
     * 设置领域对象的更新时间
     */
    void setUpdateTime(Date updateTime);

}