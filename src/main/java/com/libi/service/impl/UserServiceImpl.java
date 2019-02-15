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
        } catch (DuplicateKeyException e){
            return false;
        }
    }

    @Override
    public SysUser userLogin(String userName) {
        return sysUserMapper.selectByUsername(userName);
    }
}
