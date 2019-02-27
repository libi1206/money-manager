package com.libi.service.impl;

import com.libi.dao.SysUserMapper;
import com.libi.entity.SysUser;
import com.libi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author libi
 */
@Service()
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean userRegister(SysUser user) {
        if (user.getPassword() == null || user.getUserName() == null) {
            return false;
        }
        //密码编码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //插入数据库
        try {
            return sysUserMapper.insert(user) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public SysUser userLogin(String userName) {
        return sysUserMapper.selectByUsername(userName);
    }

    @Override
    public SysUser selectByPhoneNumber(String phone) {
        return sysUserMapper.selectByPhone(phone);
    }

    @Override
    public SysUser selectById(Long id) {
        return sysUserMapper.select(id);
    }

    @Override
    public boolean updateUserImage(String imageUrl, Long userId) {
        SysUser user = sysUserMapper.select(userId);
        user.setHeadImg(imageUrl);
        return 1 == sysUserMapper.update(user);
    }

    @Override
    public boolean updateUserInfo(SysUser user, Boolean sex, String neckName, String phone) {
        if (sex != null) {
            user.setSex(sex);
        }
        if (neckName != null) {
            user.setNeckName(neckName);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        return sysUserMapper.update(user) == 1;
    }
}
