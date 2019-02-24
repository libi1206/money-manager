package com.libi.dao;

import com.libi.base.BaseMapper;
import com.libi.entity.Family;
import com.libi.entity.FamilyMapping;
import com.libi.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
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

    /**
     * 查询一个家庭里所有的用户
     * @param familyId
     * @return
     */
    List<SysUser> selectAllUserInFamily(Long familyId);

    /**
     * 查询用户加入的所有的家庭
     * @param userId
     * @return
     */
    List<Family> selectAllFamilyInUser(Long userId);
}
