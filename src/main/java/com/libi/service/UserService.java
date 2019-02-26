package com.libi.service;

import com.libi.entity.SysUser;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author libi
 */
public interface UserService {
    /**
     * 用户注册,向用户表里面插入数据
     * @param user
     * @return
     */
    boolean userRegister(SysUser user);

    /**
     * Security框架的验证通过以后，把用户信息返回给前端
     * @param userName
     * @return
     */
    SysUser userLogin(String userName);

    /**
     * 根据电话号码选择用户
     * @param phone
     * @return
     */
    SysUser selectByPhoneNumber(String phone);

    /**
     * 更具用户ID选择用户，用于查询
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 更新用户的头像，并且把旧的头像删掉
     * @param imageUrl
     * @return
     */
    boolean updateUserImage(String imageUrl,Long userId);

    /**
     * 更新用户信息
     * @param id
     * @param sex
     * @param neckName
     * @param phone
     * @return
     */
    boolean updateUserInfo(Long id, Boolean sex, String neckName, String phone);
}
