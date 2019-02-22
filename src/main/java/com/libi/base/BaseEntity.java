package com.libi.base;

/**
 * @author libi
 * 所有实体的基础类
 */
public class BaseEntity {
    protected Long id;
    protected Long createTime;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
