package com.libi.base;

/**
 * @author libi
 * 所有实体的基础类
 */
public class BaseEntity {
    private Long id;
    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatTime() {
        return createTime;
    }

    public void setCreatTime(Long creatTime) {
        this.createTime = creatTime;
    }
}
