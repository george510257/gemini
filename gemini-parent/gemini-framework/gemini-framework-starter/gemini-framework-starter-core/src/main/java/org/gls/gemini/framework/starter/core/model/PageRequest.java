package org.gls.gemini.framework.starter.core.model;

import java.util.List;

/**
 * 分页请求
 */
public class PageRequest<T> {

    /**
     * 页码
     */
    private int pageNum;
    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 查询条件
     */
    private T params;
    /**
     * 排序字段
     */
    private List<SortOrder> orderBy;
}
