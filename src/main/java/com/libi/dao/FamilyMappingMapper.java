package com.libi.dao;

import com.libi.base.BaseMapper;
import com.libi.entity.FamilyMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author libi
 */
@Repository
public interface FamilyMappingMapper extends BaseMapper<FamilyMapping> {
    /**
     * 这里的Id传入的是用户id和家庭id
     * @param userId
     * @param familyId
     * @return
     */
    int delete(@Param("userId") Long userId, @Param("familyId") Long familyId);

    @Deprecated
    /**
     * 没有真正意义上的主键，所以没法用
     */
    int update(FamilyMapping entity);

    @Deprecated
    /**
     * 没有真正意义上的主键，所以没法用
     */
    FamilyMapping selece(Long id);
}
