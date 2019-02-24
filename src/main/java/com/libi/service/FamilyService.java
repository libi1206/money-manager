package com.libi.service;

import com.libi.entity.Family;
import com.libi.entity.SysUser;

import java.util.List;

/**
 * @author libi
 */
public interface FamilyService {
    /**
     * 当前用户创建一个家庭，并且自己是管理员
     * @param family
     * @param userId
     * @return
     */
    boolean createFamily(Family family,Long userId);

    /**
     * 当前登陆用户加入一个家庭，并且不是管理员
     * @param familyId
     * @return
     */
    boolean joinFamily(Long familyId,Long userId);

    /**
     * 用户退出一个家庭
     * @param familyId
     * @return
     */
    boolean quitFamily(Long familyId,Long userId);

    /**
     * 获取这个家庭所有的成员
     * @param familyId
     * @return
     */
    List<SysUser> getAllMembers(Long familyId);

    /**
     * 获取用户所有加入的家庭
     * @param loginUserId
     * @return
     */
    List<Family> getAllFamilies(Long loginUserId);
}
