package com.libi.dao;

import com.libi.base.BaseMapper;
import com.libi.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author libi
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    SysUser selectByUsername(String userName);

    /**
     * 根据电话号码找到用户
     * @param userName
     * @return
     */
    SysUser selectByPhone(String userName);
}
