package com.libi.base;

import java.util.List;

/**
 * @author libi
 */
public interface BaseMapper<T extends BaseEntity> {
    /**
     * 插入记录
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新记录
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 选择记录
     * @param id
     * @return
     */
    T select(Long id);

    /**
     * 拉取全部记录
     * @return
     */
    List<T> selectAll();
}
