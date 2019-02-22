package com.libi.dao;

import com.libi.base.BaseMapper;
import com.libi.entity.Assets;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author libi
 */
@Repository
public interface AssetsMapper extends BaseMapper<Assets> {

    /**
     * 选择用户下的所有资产
     * @param owner
     * @return
     */
    List<Assets> selectUserAssets(Long owner);
}
