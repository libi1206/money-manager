package com.libi.base;

/**
 * @author libi
 * 所有实体的基础类
 */
public class BaseEntity {
    private Long id;
    private Long creatTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }
}
