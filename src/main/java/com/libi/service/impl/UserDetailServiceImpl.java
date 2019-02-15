package com.libi.service.impl;

import com.libi.dao.SysUserMapper;
import com.libi.entity.SysUser;
import javafx.beans.property.SimpleListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.libi.constant.SecurityConst.*;

/**
 * @author libi
 * 这里通过用户名查询用户，并且在这里提取成实现了UserDetails接口的类
 */
@Service("UserDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectByUsername(userName);
        User userDetails = new User(sysUser.getUserName(),sysUser.getPassword(),handleAuthority(sysUser.getAuthority()));
        return userDetails;
    }

    /**
     * 负责处理数据库中的角色权限信息，把他变成SimpleGrantedAuthority类的集合
     * 现在它的逻辑是：
     *      USER ==> ROLE_USER
     *      ADMIN ==> ROLE_USER,ADMIN
     * @param auth 数据库中的权限字符串
     * @return 需要的权限类的集合
     */
    private List<SimpleGrantedAuthority> handleAuthority(String auth) {
        List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority authUser = new SimpleGrantedAuthority(ROLE_USER);
        SimpleGrantedAuthority authAdmin = new SimpleGrantedAuthority(ROLE_ADMIN);
        if (USER.equals(auth)) {
            authList.add(authUser);
        }else if(ADMIN.equals(auth)){
            authList.add(authAdmin);
            authList.add(authUser);
        }
        return authList;
    }
}
