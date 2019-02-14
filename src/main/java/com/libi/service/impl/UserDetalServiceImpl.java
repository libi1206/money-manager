package com.libi.service.impl;

import javafx.beans.property.SimpleListProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author libi
 * 这里通过用户名查询用户，并且在这里提取成实现了UserDetails接口的类
 */
@Service("UserDetailService")
public class UserDetalServiceImpl implements UserDetailsService {
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User securityUser = new User("", "", new ArrayList<SimpleGrantedAuthority>());
        return null;
    }
}
