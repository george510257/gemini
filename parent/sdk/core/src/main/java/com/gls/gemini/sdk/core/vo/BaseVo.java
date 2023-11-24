package com.gls.gemini.sdk.core.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础vo
 */
@Data
@Accessors(chain = true)
public class BaseVo implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 删除标记 0:正常;1:已删除
     */
    private Boolean deleted;
    /**
     * 创建人ID
     */
    private Long createUserId;
    /**
     * 创建人姓名
     */
    private String createUserName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人ID
     */
    private Long updateUserId;
    /**
     * 修改人姓名
     */
    private String updateUserName;
    /**
     * 更新时间
     */
    private Date updateTime;
}
